[![License: GPL v3](https://img.shields.io/badge/License-GPLv3-blue.svg)](https://www.gnu.org/licenses/gpl-3.0)
![Release](https://github.com/jimmyd-be/theGamesDbClient/workflows/Release/badge.svg?branch=master)
# theGameDbClient
Java wrapper for the Games DB API.

This version of the wrapper is based on the TheGamesDB API version [2.0.0](https://api.thegamesdb.net/).


## Usage
To use the TheGamesDB API you need to ask an apiKey on [TheGamesDB forum](https://forums.thegamesdb.net/viewforum.php?f=10&sid=4d61f72d7d3146923883402ac943e643).

```java
String apiKey = "12345789";
TheGamesDbClient client = new TheGamesDbClient(apiKey);
/*Now here you can call all the client methods
  to get the info from The Games DB.*/
```

### Maven

The library can be downloaded from the Maven central repository.

```xml
<dependency>
      <groupId>io.github.jimmyd-be</groupId>
      <artifactId>theGamesDbClient</artifactId>
      <version>1.0</version>
</dependency>
```

## Configuration
No configuration is needed to use the wrapper. The wrapper will call the api with all the fields that are possible for all the API calls. More info about the fields can be found in the [TheGamesDb API](https://api.thegamesdb.net/).