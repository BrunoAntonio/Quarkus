package data.iris;

import io.quarkus.hibernate.orm.panache.Panache;
import io.quarkus.panache.mock.PanacheMock;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.ws.rs.WebApplicationException;
import java.util.Collections;

@QuarkusTest
public class PanacheFunctionalityTest {

    @InjectMock
    FruitRepository fruitRepository;

    @Test
    public void testPanacheRepositoryMocking() throws Throwable {

        Assertions.assertEquals(0, fruitRepository.count());

        Mockito.when(fruitRepository.count()).thenReturn(23L);
        Assertions.assertEquals(23, fruitRepository.count());

        Mockito.when(fruitRepository.count()).thenReturn(43L);
        Assertions.assertEquals(43, fruitRepository.count());

        Mockito.when(fruitRepository.count()).thenCallRealMethod();
        Assertions.assertEquals(0, fruitRepository.count());

        Mockito.when(fruitRepository.count()).thenCallRealMethod();
        Assertions.assertEquals(0, fruitRepository.count());

        Mockito.verify(fruitRepository, Mockito.times(5)).count();

        Fruit p = new Fruit();
        Mockito.when(fruitRepository.findById(12L)).thenReturn(p);
        Assertions.assertSame(p, fruitRepository.findById(12L));
        Assertions.assertNull(fruitRepository.findById(42L));

        Mockito.when(fruitRepository.findById(12L)).thenThrow(new WebApplicationException());
        Assertions.assertThrows(WebApplicationException.class, () -> fruitRepository.findById(12L));

        Mockito.when(fruitRepository.findFruits("p")).thenReturn(Collections.emptyList());
        Assertions.assertTrue(fruitRepository.findFruits("p").isEmpty());

        Mockito.verify(fruitRepository).findFruits("p");
        Mockito.verify(fruitRepository, Mockito.atLeastOnce()).findById(Mockito.any());
        Mockito.verifyNoMoreInteractions(fruitRepository);
    }

}
