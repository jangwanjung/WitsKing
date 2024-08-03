package king.witsking.model;

import lombok.Data;

@Data
public class KakaoProfile {
    private String id;
    private String connected_at;
    private Properties properties;
    private Kakao_account kakao_account;

    @Data
    public class Properties {
        private String nickname;
    }

    @Data
    public class Kakao_account {
        private Boolean profile_nickname_needs_agreement;
        private Profile profile;
        @Data
        public class Profile {
            private String nickname;
            private Boolean is_default_nickname;
        }
    }

}
