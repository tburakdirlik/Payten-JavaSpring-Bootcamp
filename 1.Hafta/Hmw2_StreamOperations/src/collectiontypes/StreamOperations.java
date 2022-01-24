package collectiontypes;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamOperations {

    //Collection concat method
    public static <T> Collection<T> concat(Collection<T> first, Collection<T> second) {

        Collection<T> concatenated = Stream
                .concat(first.stream(), second.stream())
                .collect(Collectors.toList());
        return concatenated;
    }
    
    
    //Difference method: Returns the elements in the first collection that the second collection is not in 
    public static <T> Stream<T> difference(Collection<T> first, Collection<T> second) {

        Stream<T> stream = first.stream();
        return stream.filter(X -> !(second.contains(X)));
    }

    //Distinct method: Returns a new stream list with any duplicates removed.
    public static <T> Stream<T> distinct(Collection<T> first) {

        Stream<T> c = first.stream()
                .distinct();
        return c;

    }

    //Slice method: Return a sub-sequence of the list between the given first and last positions.
    public static <T> Stream slice(Collection<T> first, int firstindex, int lastindex) {
        Stream<T> stream = first.stream();
        Stream.iterate(firstindex, n -> n + 1)
                            .limit(lastindex + 1)
                            .forEach(System.out::println);
        return stream;
    }
    
    //Sort method: Return an increasing order collection list 
    public static <T> Stream sort(Collection<T> first){
        return first.stream().sorted();
    }

    //Union method: Return a concatenated collection list without duplicate elements
    public static <T> Stream union(Collection<T> first, Collection<T> second){
        Collection<T> concatenated = Stream
                .concat(first.stream(), second.stream())
                .collect(Collectors.toList());
        
        Stream<T> union = concatenated.stream()
                            .distinct();
        return union;
    }
    
    //Intersection method: Return intersection elements of given collection lists
    public static <T> Stream intersection(Collection<T> first, Collection <T> second){
        
        Stream <T> intersection1 = first.stream()   
                .filter(second::contains);
        return intersection1;
                
    }

    public static void main(String[] args) {

        //Collection data structures created below
        Collection<Integer> collection1 = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        Collection<Integer> collection2 = Arrays.asList(9, 3, 2 , 2);
        List<Integer> collection = Arrays.asList(9, 3, 2);

        //Lets try these methods
        System.out.println(concat(collection1, collection2));
        System.out.println(difference(collection1, collection).collect(Collectors.toList()));
        System.out.println(distinct(collection1).collect(Collectors.toList()));
        System.out.println("--------------");
        slice(collection1, 0, 3);
        System.out.println(sort(collection2).collect(Collectors.toList()));
        System.out.println(union(collection1, collection2).collect(Collectors.toList()));
        System.out.println("---------------");
        System.out.println(intersection(collection1, collection2).collect(Collectors.toList()));

    }
}
