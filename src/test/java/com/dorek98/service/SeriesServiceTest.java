package com.dorek98.service;

import com.dorek98.dto.series.SeriesDetails;
import com.dorek98.dto.series.SeriesRegistration;
import com.dorek98.model.Platform;
import com.dorek98.model.Series;
import com.dorek98.repository.SeriesRepository;
import com.dorek98.service.series.SeriesCommandHandlerImpl;
import com.dorek98.service.series.SeriesQueryHandlerImpl;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class SeriesServiceTest {

    @Autowired
    SeriesCommandHandlerImpl seriesCommandHandler;
    @Autowired
    SeriesRepository seriesRepository;
    @Autowired
    SeriesQueryHandlerImpl seriesQueryHandler;

    @Test
    public void should_be_able_to_save_series() {
        //given: We have sample actor
        Series sampleSeries = new Series("TestSeries", 1, Platform.HBO, 2021);

        //when: We try to save series to database
        seriesRepository.save(sampleSeries);
        long idSeries = sampleSeries.getSeries_id();

        //then: Series should exist in database
        Assert.assertTrue(seriesRepository.existsById(idSeries));

        //clean
        seriesRepository.deleteById(idSeries);
    }

    @Test
    public void should_be_able_to_update_series() {
        //given: We have sample series in database
        Series sampleSeries = new Series("TestSeries", 1, Platform.HBO, 2021);
        seriesRepository.save(sampleSeries);
        long idSeries = sampleSeries.getSeries_id();

        //when: We try to update series
        Optional<SeriesDetails> updatedSeries = seriesCommandHandler.update(idSeries, new SeriesRegistration("Test1", 2, Platform.HBO, 2022));

        //then: Series should be updated
        Assert.assertTrue(updatedSeries.isPresent());
        Assert.assertEquals(idSeries, updatedSeries.get().getId());
        Assert.assertEquals("Test1", updatedSeries.get().getTitle());
        Assert.assertEquals(2, updatedSeries.get().getNumberOfSeasons());
        Assert.assertEquals(2022, updatedSeries.get().getYearOfPremiere());

        //clean
        seriesRepository.deleteById(idSeries);
    }

    @Test
    public void should_not_be_able_to_find_not_existing_series() {
        //given: We have not existing id
        long notExistingId = 1000;

        //when: We try to find series with not existing id
        Optional<SeriesDetails> series = seriesQueryHandler.findById(notExistingId);

        //then: Series should be null
        Assert.assertTrue(series.isEmpty());
    }
}