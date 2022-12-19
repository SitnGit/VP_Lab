package mk.ukim.finki.wp.lab;

import mk.ukim.finki.wp.lab.model.Balloon;
import mk.ukim.finki.wp.lab.model.Manufacturer;
import mk.ukim.finki.wp.lab.repository.jpa.BalloonRepositoryJPA;
import mk.ukim.finki.wp.lab.repository.jpa.ManufacturerRepositoryJPA;
import mk.ukim.finki.wp.lab.service.BalloonService;
import mk.ukim.finki.wp.lab.service.ManufacturerService;
import mk.ukim.finki.wp.lab.service.impl.BalloonServiceImpl;
import mk.ukim.finki.wp.lab.service.impl.ManufacturerServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SaveBalloonTest {

    @Mock
    private BalloonRepositoryJPA balloonRepositoryJPA;
    private BalloonServiceImpl balloonService;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);

        this.balloonService = Mockito.spy(new BalloonServiceImpl(this.balloonRepositoryJPA));


        Balloon balloon = new Balloon("name","description",new Manufacturer("manufacturer"));
        Mockito.when(this.balloonRepositoryJPA.save(Mockito.any(Balloon.class))).thenReturn(balloon);

    }

    @Test
    public void testSuccessSave(){
        Balloon balloon = this.balloonService.createBalloon("name","description",new Manufacturer("manufacturer"));
        Mockito.verify(this.balloonService).createBalloon("name","description",new Manufacturer("manufacturer"));

        Assert.assertNotNull("Balloon is null",balloon);
        Assert.assertEquals("Name does not match","name",balloon.getName());
        Assert.assertEquals("Description does not match","description",balloon.getDescription());
        Assert.assertEquals("Manufacturer does not match",new Manufacturer("manufacturer"),balloon.getManufacturer());
    }

    @Test
    public void testNameNull(){
        Assert.assertThrows("IllegalArgumentException expected",IllegalArgumentException.class,
                ()->this.balloonService.createBalloon(null,"description",new Manufacturer("manufacturer")));
        Mockito.verify(this.balloonService).createBalloon(null,"description",new Manufacturer("manufacturer"));
    }

    @Test
    public void testDescNull(){
        Assert.assertThrows("IllegalArgumentException expected",IllegalArgumentException.class,
                ()->this.balloonService.createBalloon("name",null,new Manufacturer("manufacturer")));
        Mockito.verify(this.balloonService).createBalloon("name",null,new Manufacturer("manufacturer"));
    }

    @Test
    public void testManNull(){
        Assert.assertThrows("IllegalArgumentException expected",IllegalArgumentException.class,
                ()->this.balloonService.createBalloon("name","description",null));
        Mockito.verify(this.balloonService).createBalloon("name","description",null);
    }

}
