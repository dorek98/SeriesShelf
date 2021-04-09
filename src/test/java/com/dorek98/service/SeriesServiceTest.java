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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

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
        long idSeries = sampleSeries.getSeriesId();

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
        long idSeries = sampleSeries.getSeriesId();

        //when: We try to update series
        ResponseEntity<SeriesDetails> updatedSeries = seriesCommandHandler.update(idSeries, new SeriesRegistration("Test1", 2, Platform.HBO, 2022));

        //then: Series should be updated
        Assert.assertNotNull(updatedSeries.getBody());
        Assert.assertEquals(idSeries, updatedSeries.getBody().getId());
        Assert.assertEquals("Test1", updatedSeries.getBody().getTitle());
        Assert.assertEquals(2, updatedSeries.getBody().getNumberOfSeasons());
        Assert.assertEquals(2022, updatedSeries.getBody().getYearOfPremiere());

        //clean
        seriesRepository.deleteById(idSeries);
    }

    @Test
    public void should_not_be_able_to_find_not_existing_series() {
        //given: We have not existing id
        long notExistingId = 1000;

        //when: We try to find series with not existing id
        ResponseEntity<SeriesDetails> series = seriesQueryHandler.findById(notExistingId);

        //then: Series should be null
        Assert.assertNull(series.getBody());
        Assert.assertEquals(series.getStatusCode(), HttpStatus.NOT_FOUND);
    }
}