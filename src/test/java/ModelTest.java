import model.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ModelTest {

    @Test
    public void should_be_able_to_add_main_role() {
        //given: We have actor data and sample series
        final Actor sampleActor = new Actor("Kit", "Harington", 34);
        final Series sampleSeries = createSampleSeries();

        //when: We try to add role
        sampleSeries.addRole("John Snow", sampleActor);

        //then: Role should be added
        assertTrue(sampleSeries.getMainRoles().containsValue(sampleActor));
    }

    @Test
    public void should_not_be_able_to_add_the_same_main_role() {
        //given: We have actor data and sample series
        final Actor sampleActor1 = createSampleActor();
        final Actor sampleActor2 = createSampleActor2();
        Series sampleSeries = createSampleSeries();

        //when: We try to add role
        sampleSeries.addRole("Jon Snow", sampleActor1);
        sampleSeries.addRole("Jon Snow", sampleActor2);

        //then: Role should not be added
        assertFalse(sampleSeries.getMainRoles().containsValue(sampleActor2));
    }

    @Test
    public void should_be_able_to_add_series_to_shelf() {
        //given: We have sample series and shelf
        final Shelf sampleShelf = new Shelf("Favourite");
        final Series sampleSeries = createSampleSeries();

        //when: We try to add series
        sampleShelf.addSeries(sampleSeries);

        //then: Role should be added
        assertTrue(sampleShelf.getSeriesList().contains(sampleSeries));
    }

    @Test
    public void should_not_be_able_to_add_the_same_series_to_shelf() {
        //given: We have sample series and shelf
        final Shelf sampleShelf = new Shelf("Favourite");
        final Series sampleSeries = createSampleSeries();
        final Series sampleSeriesWithSameTitle = createSampleSeriesWithSameTitle();

        //when: We try to add series
        sampleShelf.addSeries(sampleSeries);
        sampleShelf.addSeries(sampleSeriesWithSameTitle);

        //then: Series should not be added
        assertFalse(sampleShelf.getSeriesList().contains(sampleSeriesWithSameTitle));
    }

    public Series createSampleSeries() {
        return new Series("Test title", 1, Platform.HBO, 2010);
    }

    public Series createSampleSeriesWithSameTitle() {
        return new Series("Test title", 2, Platform.HBO, 2011);
    }

    public Actor createSampleActor() {
        return new Actor("Kit", "Harington", 34);
    }

    public Actor createSampleActor2() {
        return new Actor("Sean", "Bean", 61);
    }


}
