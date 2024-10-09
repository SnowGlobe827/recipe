package com.rcp.rfg.jpa.entity;

import java.time.LocalDate;
import java.util.Date;

import com.rcp.rfg.enums.UsersConsent;
import com.rcp.rfg.enums.UsersGender;
import com.rcp.rfg.enums.UsersRole;
import com.rcp.rfg.enums.UsersStatus;

import jakarta.persistence.*;
import lombok.*;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class UserEntity {

	//회원번호
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //회원 아이디
    @Column(nullable = false, unique = true, length = 100)
    private String username;

    //회원 이메일
    @Column(nullable = false, unique = true, length = 100)
    private String email;

    //회원 비밀번호
    @Column(nullable = false, length = 255)
    @Setter  // 비밀번호는 외부에서 변경 가능하도록 Setter 추가
    private String password;

    //회원 닉네임
    private String nickname;

    //회원 프로필 사진
    private String profileImage;

    //회원 전화번호
    @Column(length = 20)
    private String phoneNumber;

    //회원 성별 (M, F, O)
    @Enumerated(EnumType.STRING)
    private UsersGender gender;

    //회원 생일
    private LocalDate birthdate;

    //회원 주소
    private String address;

    //회원 가입일자
    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @Builder.Default
    private Date registrationDate = new Date();  // 등록일은 빌더에서 기본값 설정

    //회원 마지막 로그인 일자
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastLogin;

    //회원 권한
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private UsersRole role = UsersRole.USER;  // 빌더에서 기본값 설정

    //회원 계정 상태 (Y활성화, N탈퇴, B강제차단)
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private UsersStatus status = UsersStatus.Y;  // 빌더에서 기본값 설정

    //회원 상태메세지
    @Lob
    private String bio;

    //회원 개인정보동의 (Y,N)
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private UsersConsent consentPrivacy = UsersConsent.N;  // 빌더에서 기본값 설정

    //회원 개인정보 동의일자
    @Temporal(TemporalType.TIMESTAMP)
    private Date consentPrivacyDate;

    // 등록일 자동 설정
    @PrePersist
    protected void onCreate() {
        this.registrationDate = new Date();
    }

    // 마지막 로그인 시간 자동 업데이트 (옵션에 따라 설정 가능)
    @PreUpdate
    protected void onUpdate() {
        this.lastLogin = new Date();
    }
}
