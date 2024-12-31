package project.unitTesting;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class Example5_02 {

    @Mock
    IDatabase stub;

    @Test
    void Creating_a_report() throws Exception {
        // given
        given(stub.getNumberOfUsers()).willReturn(10);
        final Controller sut = new Controller(stub);

        // when
        final Report report = sut.createReport();

        // then
        assertThat(report.getNumberOfUsers()).isEqualTo(10);
    }

}
