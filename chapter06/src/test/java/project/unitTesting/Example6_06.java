package project.unitTesting;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;

public class Example6_06 {

    @Test
    void A_new_files_is_created_when_the_current_file_overflows() throws Exception {
        // given
        final String directoryName = "audits";
        final IFileSystem fileSystemMock = mock(IFileSystem.class);
        given(fileSystemMock.getFiles(directoryName)).willReturn(
                List.of("audits/audit_1.txt", "audits/audit_2.txt")
        );
        given(fileSystemMock.readAllLines("audits/audit_2.txt")).willReturn(
          List.of("Peter; 2019-04-06T16:30:00", "Jane; 2019-04-06T16:40:00", "Jack; 2019-04-06T17:00:00")
        );
        final AuditManager_V2 sut = new AuditManager_V2(3, directoryName, fileSystemMock);

        // when
        sut.addRecord("Alice", LocalDateTime.parse("2019-04-06T18:00:00"));

        // then
        then(fileSystemMock).should().writeAllText("audits/audit_3.txt", "Alice;2019-04-06T18:00:00");
    }
}
