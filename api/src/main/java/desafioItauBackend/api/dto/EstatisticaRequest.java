package desafioItauBackend.api.dto;

import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.DoubleSummaryStatistics;

@Service
@Getter
public class EstatisticaRequest {


    private long count;
    private double sum;
    private double avg;
    private double min;
    private double max;


    public EstatisticaRequest() {
        this(new DoubleSummaryStatistics());
    }

    public EstatisticaRequest(final DoubleSummaryStatistics doubleSummaryStatistics) {
        this.count = doubleSummaryStatistics.getCount();
        this.sum = doubleSummaryStatistics.getSum();
        this.avg = doubleSummaryStatistics.getAverage();
        this.min = doubleSummaryStatistics.getMin() == Double.POSITIVE_INFINITY ? 0 : doubleSummaryStatistics.getMin();
        this.max = doubleSummaryStatistics.getMax() == Double.POSITIVE_INFINITY ? 0 : doubleSummaryStatistics.getMax();
    }

}
