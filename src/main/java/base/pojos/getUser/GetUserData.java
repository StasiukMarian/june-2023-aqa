package base.pojos.getUser;

import lombok.Data;
@Data
public class GetUserData {
    private Integer id;
    private String email;
    private String first_name;
    private String last_name;
    private String avatar;
}
