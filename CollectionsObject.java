package java_2hours_lecture_vs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CollectionsObject {
  
  @Test
  @DisplayName("매개변수를 값으로 전달")
  public void primitiveParameterTest(){
    int age = 100;
    int newAge = changeAge(age);
    assertEquals(30, newAge);

    assertEquals(10, age); // Error : changeAge()에서 age를 10으로 대입, 하지만 age 값은 100. 
  }

  private int changeAge(int age){
    age = 10;
    int newAge = age + 20;
    return newAge;
  }

  @Test
  @DisplayName("매개변수를 참조로 전달")
  public void referenceObjecttest(){
    var names = new ArrayList<String>(List.of("Raphael", "Arthur", "Luna", "Winter")); //List.of()는 초기화에 사용합니다.
    assertEquals("Luna", names.get(2));

    var newNames = changeName(names, 2, "Mingi");
    assertEquals("Mingi", newNames.get(2));
    assertEquals(names.get(2), newNames.get(2)); //둘다 mingi
  }

  private <T> List<T> changeName(List<T> names, int index, T name){ //제너릭 사용
    names.set(index, name);
    List<T> newNames = new ArrayList<>(names);
    return newNames;
  }

}
