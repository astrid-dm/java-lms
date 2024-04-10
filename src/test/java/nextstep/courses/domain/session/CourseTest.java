package nextstep.courses.domain.session;

import nextstep.courses.domain.Course;
import nextstep.courses.domain.session.image.CoverImage;
import nextstep.users.domain.Users;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CourseTest {

    @Test
    @DisplayName("과정 생성 - 유료 강의, 무료 강의 추가")
    void testCourse_paidSession() {
        List<Session> sessions = List.of(getFreeSession(), getPaidSession());
        Course course = Course.of(1L, "TEST", 1L, 1L,
                LocalDateTime.now(), LocalDateTime.now(), sessions);

        assertEquals(course.getNumberOfSessions(), 2);
    }

    private PaidSession getPaidSession() {
        Long sessionId = 1L;
        Long fee = 10000L;
        SessionPeriod sessionPeriod = SessionPeriod.of(
                LocalDateTime.of(2024,1,1,0,0,0),
                LocalDateTime.of(2024,4,1,0,0,0));
        CoverImage coverImage = CoverImage.of("jpg", 1024, 300,200);
        Users users = new Users();

        return new PaidSession(sessionId, sessionPeriod, coverImage,
                SessionStatusEnum.OPEN, users, 1, fee);
    }

    private FreeSession getFreeSession() {
        Long sessionId = 1L;
        SessionPeriod sessionPeriod = SessionPeriod.of(
                LocalDateTime.of(2024,1,1,0,0,0),
                LocalDateTime.of(2024,4,1,0,0,0));
        CoverImage coverImage = CoverImage.of("jpg", 1024, 300,200);
        Users users = new Users();

        return new FreeSession(sessionId, sessionPeriod, coverImage, SessionStatusEnum.OPEN, users);
    }

}
