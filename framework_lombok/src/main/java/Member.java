import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*

@ToString
@EqualsAndHashCode
@Getter
@Setter
@NoArgsConstructor

=> @Data하나로 통일가능
 */

@Data
@AllArgsConstructor
public class Member {
  
    private String name;
    private int age;
    private String email;
    private String phoneNumber;

    // getter, setter, toString, equals, hashCode 등 필요한 메서드 작성
    // *alt + shift + s -> generate code 단축키

    
}
