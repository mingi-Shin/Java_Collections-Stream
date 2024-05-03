package java_2hours_lecture_vs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CollectionInterfaces {
  
  //배열
  @Test
  @DisplayName("배열")
  public void array(){

    String[] name = {"Raphael", "Winter", "Karina", "array"};
    assertEquals("Raphael", name[0]);

    for (String n : name){
      System.out.println(n);
    }

    Arrays.asList(name).forEach(n -> System.out.print(n+ "-"));

  }
  
  //iterable forEach
  @Test
  @DisplayName("iterable")
  public void iterable(){

    Iterable<String> iter = Arrays.asList("raphael", "Winter","Karina"); //Arrays.asList() : 배열을 List로 변환하는 메서드
    //Iterable의 'Type계층구조표시'를 클릭해보면 Collection 인터페이스가 더 하위항목임을 알 수 있다.

    iter.forEach(n -> {
      System.out.println(n);
    });
  }

  //collection
  @Test
  @DisplayName("Collection")
  public void collection(){

    //Collection이 더 상위 인터페이스, ArrayList는 List인터페이스를 구현한 클래스, List는 Collection 인터페이스의 하위 인터페이스.
    Collection<String> collection = new ArrayList<>(); 
    collection.add("Raphael");
    assertTrue(collection.contains("Raphael"));
    assertFalse(collection.contains("Winter"));

  }

  //List
  @Test
  @DisplayName("List")
  public void list(){
    
    var names = new ArrayList<String>(); //List 인터페이스에서 가장 대표적인 클래스 : ArrayList
    names.addAll(List.of("Raphael", "Winter", "Karina"));

    assertEquals("Winter", names.get(1)); // List는 순서가 보장됨.
  }

  //Set
  @Test
  @DisplayName("Set")
  public void set(){

    var coupons = new HashSet<String>(); //Set인터페이스에서 가장 대표적인 클래스 : HashSet
    coupons.addAll(List.of("Raphael", "Winter", "Karina"));
    coupons.add("Karina");

    assertEquals(3, coupons.size()); //Karina를 한번 더 add했지만 Set 자료형이어서 중복 불가.

    for (String n : coupons){
      System.out.println(n);
    }
  }

  //Map
  @Test
  @DisplayName("Map")
  public void map(){

    Map<String, String> persons = new HashMap<>();
    persons.put("a101", "Raphael"); //Map은 Collection 인터페이스에 속하지 않아서 add()가 없어.
    persons.put("a102", "Winter");
    assertEquals("Winter", persons.get("a102"));
    
  }


}
