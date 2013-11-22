package ui;

import katahistogram.Histogram;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

public class ChartHistrogramViewer<T> extends HistogramViewer<T> {

    public ChartHistrogramViewer(Histogram<T> histrogram) {
        super(histrogram);
    }

    @Override
    public void show() {
        ApplicationFrame frame = new ApplicationFrame("Histogram");
        frame.add(createChartPanel());
        frame.pack();
        frame.setVisible(true);
    }

    private ChartPanel createChartPanel() {
        ChartPanel panel = new ChartPanel(createChart());
        return panel;
    }

    private JFreeChart createChart() {
        JFreeChart chart = ChartFactory.createBarChart("Histogram", "Categories", "Frecuency", createDataSet());
        return chart;
    }

    private CategoryDataset createDataSet() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (T item : getHistogram().keySet()) {
            dataset.addValue(getHistogram().get(item), "Categories", (String)item);
        }
        return dataset;
    }
    
}
