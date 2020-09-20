# KibiDB-Driver-Java
Library written in Java to communicate with KibiDB Server and be able to insert, obtain, modify, clean data stored in KibiDB.

### Usage

```java
// There are several constructors, this is the most recommended
Client client = new Client(address, port, password);

//Insert a new record if it doesn't exist (will replace if it already exists)
client.getConnection().insert(key, value);

//Request a data already stored in KibiDB Server
client.getConnection().get(key);//this return string

//Modify the value of a record
client.getConnection().set(key, value);

//Remove a record
client.getConnection().remove(key);

//Clear all records
client.getConnection().clear();
```

##### Dependencies:

```xml
    <dependencies>
        <dependency>
            <groupId>com.kibi.driver</groupId>
            <artifactId>KibiDB-Driver-Java</artifactId>
            <version>1.0</version>
            <scope>system</scope>
            <systemPath>${project.basedir}/lib/KibiDB-Driver-Java.jar</systemPath>
        </dependency>
    </dependencies>
```