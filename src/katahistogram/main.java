package katahistogram;

import ui.HistogramViewer;
import persistance.PersonLoader;
import ui.ChartHistrogramViewer;
import java.util.ArrayList;

public class main {

    public static void main(String[] args) {
        PersonLoader loader = createPersonLoader() ;
        HistogramBuilder<Person> builder = createBuilder(loader.load());
        HistogramViewer<String> viewer = createHistogramViewer(builder.build(createAttributeExtractor()));
        viewer.show();
    }

    private static PersonLoader createPersonLoader() {
        return new PersonLoader() {

            @Override
            public Person[] load() {
                ArrayList<Person> list = new ArrayList<>();
                list.add(new Person ("maria", new Email ("maria@gmail.com"), Sex.FEMALE));
                list.add(new Person ("mar", new Email ("mar@hotmail.com"), Sex.FEMALE));
                list.add(new Person ("juan", new Email ("juan@yahoo.com"), Sex.MALE));
                list.add(new Person ("pepe", new Email ("pepe@hotmail.com"), Sex.MALE));
                list.add(new Person ("lola", new Email ("lola@gmail.com"), Sex.FEMALE));
                list.add(new Person ("ll", new Email ("ll@gmail.com"), Sex.FEMALE));
                list.add(new Person ("sara", new Email ("sara@yahoo.com"), Sex.FEMALE));
                list.add(new Person ("marcos", new Email ("marcos@hotmail.com"), Sex.FEMALE));
                list.add(new Person ("pablo", new Email ("pablo@gmail.com"), Sex.MALE));
                list.add(new Person ("marta", new Email ("marta@gmail.com"), Sex.FEMALE));
                return list.toArray(new Person[0]);
            }
        };
    }

    private static HistogramBuilder<Person> createBuilder(Person[] collection) {
        return new HistogramBuilder<>(collection);
    }

    private static ChartHistrogramViewer<String> createHistogramViewer(Histogram<String> histogram) {
        return new ChartHistrogramViewer<>(histogram);
    }
    
    private static AttributeExtractor<Person,String> createAttributeExtractor(){
        return new AttributeExtractor<Person, String>() {

           @Override
           public String extract(Person person) {
              return person.getEmail().getDomain();
           }
       };
    }
}
