# OpenScenarioApi

## Abstract
* Extensive library for reading and checking scenarios.
* Fully compliant to [OpenSCENARIO 1.0.](https://www.asam.net/standards/detail/openscenario/)
* Includes an executable checker (See example).
* Implementation platforms JAVA (C++ in progress).

## Features
* Reading and processing of XML scenario files.
* Precise warnings and errors on a line and column based file location.
* API for browsing the OpenSCENARIO tree.

### More Features
* Resolving $notated parameters
* Resoving catalog references
* Resolving object refrences
* Checking model constraints from the standard (Range checker rules)

### Architectural features and extension points

* **Abstracting the model from its implementation** Feature: Providing an API to browse the tree.
* **Abstracting from storage media** Extension Point: Reading from zipped files, from databases or from the cloud by writing your own resource locator classes.
* **Abstracting from storage formats** Extension Point: Write your own loader class to read from binary files or from JSON etc.
* **Checker rule API** Extension Point: Write your own checker rules. E.g. for your company‘s set of authoring guidelines.
* **Architecture is transferable to different platforms** JAVA, C++, Python

## Use Cases
### Primary Use Cases
* Using the library as a stand alone checker.
* Integrating the library in simulators and editors.
* Analyzing scenarios for labeling issues (e.g. in OpenLabel).

### More Use Cases
* Building customer specific sets of authoring guidelines with the generic checker rule interface.
* Enabling reading access to backends and to the cloud.
* Analyzing scenarios for building comparators, doing data mining etc.
* Storing precompiled scenarios in efficient storage formats in databases.

# Building the Sources
## JAVA
* Clone the master branch (the `java` path from this project)
* Install maven
* Make sure that the maven binary directory is set in your environment
* Make sure that JAVA_HOME is set and points to a jdk (version 8 or above).
* Change your current dir to the `java` directory.
* Execute `mvn install`

Three packages are built in the `target` folder.

| package | description |
|-|-|
| de.rac.openscenario.v1_0.reader-X.Y.Z-SNAPSHOT.jar | A package that includes the compiled source code |
| de.rac.openscenario.v1_0.reader-X.Y.Z-SNAPSHOT-jar-with-dependencies.jar | A package that includes the compiled source code with any dependency embedded. |
| de.rac.openscenario.v1_0.reader-X.Y.Z-SNAPSHOT-javadoc.jar | The javadoc documentation|






