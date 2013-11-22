package ui;

import katahistogram.Histogram;

public class ConsoleHistogramViewer<T> extends HistogramViewer<T> {

    public ConsoleHistogramViewer(Histogram<T> histrogram) {
        super(histrogram);
    }    
    
    @Override
    public void show (){
        for (T item : getHistogram().keySet()) {
            System.out.println(item + ": " + getHistogram().get(item));            
        }
    }
}
