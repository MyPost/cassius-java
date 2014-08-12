# cassius-java

[![Build Status](https://travis-ci.org/MyPost/cassius-java.png?branch=master)](https://travis-ci.org/MyPost/cassius-java)

[Cassandra](http://cassandra.apache.org/) as a big nested map, jvm compatibility version.

## Installation

Leiningen:
```clojure
[au.com.auspost/cassius-java "0.1.14"]
```

Gradle:
```groovy
compile "au.com.auspost:cassius-java:0.1.14"
```

Maven:
```xml
<dependency>
  <groupId>au.com.auspost</groupId>
  <artifactId>cassius-java</artifactId>
  <version>0.1.14</version>
</dependency>
```
## Usage

Please see [cassius](https://github.com/MyPost/cassius) for more use cases. This is a small wrapper around the main library functionality. A sample can be seen below in java:

```java
import clojure.lang.api.Clojure;
import clojure.lang.IFn
import au.com.auspost.Cassius;
import java.util.Hashtable;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import clojure.lang.Keyword;

public class HelloCassius
{
    public static void main(String[] args)
    {
        String host = "localhost";
        long port = 29160;
        Hashtable<Keyword, Keyword> options = new Hashtable<Keyword, Keyword>();
        options.put(Keyword.intern("value-type"), Keyword.intern("utf-8"));
        Cassius cass = new Cassius(host, port, options);
        
        cass.dropIn(); // Clears the entire database
        System.out.println("After dropIn: "+ cass.peekIn().toString()); // Clears the entire database
        
        cass.putIn((ArrayList)Clojure.read("[\"app\"]"), (Map)Clojure.read("{\"user\" {\"1\" {\"age\"  \"10\"}}}"));
        System.out.println("After putIn: "+ cass.peekIn().toString()); // After putIn operation.
        
        cass.putIn((ArrayList)Clojure.read("[]"), (Map)Clojure.read("{\"app\" {\"user\" {\"1\" {\"age\" \"10\"}}}}"));
        System.out.println("After putIn: "+ cass.peekIn().toString()); // After second putIn operation.
    }
}
```

## Contributors

 - Chris Zheng     (Australia Post)

## License

Copyright © 2014 Australia Postal Corporation