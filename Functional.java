package java_2hours_lecture_vs;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.conversions.BigDecimalConversion;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

import java.util.function.*;
import java.math.BigDecimal;


public class Functional {
  // consumer
  @Test
  @DisplayName("consumer") //input만 있다.
  public void consumer(){
    Consumer<String> eat = (food) -> {    //왼쪽(food)이 input, 오른쪽이 output, <String>제너릭은 input의 타입
      System.out.println(food);
 
    }; 
    eat.accept("apple");

  }

  //supplier
  @Test
  @DisplayName("supplier") //output만 있다.
  public void supplier(){
    Supplier<Integer> salary = () -> 300; //<Integer>제너릭은 output의 타입
    
    Supplier<Integer> salary2 = () -> {
      return 1000;
    };

    Supplier<String> salary3 = () -> {
      return "얼마일까요 알아맞춰보세요.";
    };

    int result = salary.get();
    assertEquals(300, result);
    int result2 = salary2.get();
    assertEquals(1000, result2);
    String result3 = salary3.get();
    System.out.println(result3);
  }

  //function
  @Test
  @DisplayName("function")
  public void function(){
    //BigDecimal : 금융 계산, 세금 및 부가세 계산, 정밀한 수치 연산 등과 같이 정확한 결과가 필요한 많은 분야에서 사용됩니다.
    Function<BigDecimal, BigDecimal> exchange = (dallar) -> //왼쪽이 input자료형, 오른쪽이 output자료형
      dallar.multiply(BigDecimal.valueOf(1356.05));

    double num = 45.35;
    BigDecimal exchanged = exchange.apply(BigDecimal.valueOf(num)).setScale(5, BigDecimal.ROUND_HALF_UP); 
    
    System.out.println(num + "달러는 한국돈으로 환산시에 " + exchanged + "원입니다." );

  }

  //predicate
  @Test
  @DisplayName("predicate")
  public void predicate(){ //Boolean 형태입니다.
    Predicate<String> predicate = (name) -> "Winter".equals(name);
    
    Predicate<String> predicate2 = (name) -> {
      return "Raphael".equals(name);
    };

    Boolean test01 = predicate.test("Winter");
    System.out.println(test01);

    Boolean test02 = predicate2.test("Karina");
    System.out.println(test02);

  }



  //함수형 프로그래밍 응용 (아래의 예시는 전략 패턴)
  @Test
  @DisplayName("함수형 프로그래밍 응용")
  public void functionalParams(){
    Function<Integer, Grade> schoolGradeCalcurator = (score) -> {
      int gradeNum = score / 10;
      Grade result = switch(gradeNum){
        case 9 -> Grade.A;
        case 8 -> Grade.B;
        case 7 -> Grade.C;
        case 6 -> Grade.D;
        default -> Grade.F;
      };
      return result;
    };

    Grade grade = getGradeByScore(80, schoolGradeCalcurator);
    System.out.println(grade);

  }

  private Grade getGradeByScore(int score, Function<Integer, Grade> calcurator) {
    return calcurator.apply(score);
  }

  enum Grade {
    A, B, C, D, F
  }
  
}
