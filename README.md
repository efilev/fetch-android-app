# REST API and Sorting Exercise

This application was developed using a popular open-source client, Retrofit, and Java. Retrofit can easily be used for both Kotlin and Java, making this a useful project template to convert to Kotlin and learn more about the language.

## Project Goals
- Display all items sorted by listid
- After sorting by listid, sort by name
- Filter out items where “name” is null or “”

## Process
1. Create listview populated with dummy values
2. Add retrofit library. Add to ```libs.versions.toml```, then add to gradle build
3. For the purpose of this project fitting the instruction, I used Android 14, API 34 and a Pixel 9 to display my example app. However, I normally would work on a lower API to allow for more users to have access (34 is only accessible by ~13% of users)
5. Created API call interface that contains the get request and parses the JSON
6. Created ```User``` class with matching values
7. Created ```UserAdapter``` class to convert data into RecyclerView. Each value binded to a TextView
8. In ```MainActivity```, use create Retrofit builder. Use to send a request to web server
9. Provide Toast message based on whether or not the response was received
10. If response is successful, add all the data into an ArrayList
11. Sort ArrayList using Collections.sort() and custom-made comparator. Sorted by ```listid``` and ```name```
