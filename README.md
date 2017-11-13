# JPA-MyPage
## Use JPA
```
{
    "number": 0,
    "last": false,
    "numberOfElements": 2,
    "size": 2,
    "totalPages": 3,
    "sort": null,
    "content": [
        {
            "idCard": "41524134",
            "name": "王宸昊",
            "id": "1",
            "schoolName": "北京科技大学",
            "age": 21
        },
        {
            "idCard": "41523511",
            "name": "张三",
            "id": "2",
            "schoolName": "北京大学",
            "age": 22
        }
    ],
    "first": true,
    "totalElements": 5
}
```

## Use My PageUtil
```
{
    "number": 0,
    "last": false,
    "numberOfElements": 2,
    "size": 2,
    "totalPages": 3,
    "content": [
        [
            "1",
            21,
            "41524134",
            "王宸昊",
            "北京科技大学"
        ],
        [
            "2",
            22,
            "41523511",
            "张三",
            "北京大学"
        ]
    ],
    "first": true,
    "totalElements": 5
}
```

## How to use
Change the database information in application.properties
Run the project
Visit http://localhost:8080/jpa/student/get/jpaPage?page=0?size=2 and http://localhost:8080/jpa/student/get/myPage?page=0?size=2
You can see the result Json

You can find class PageUtil in package util.
In the method of constructor you can find that how each variable is assigned.
In Service , you need create 2 sql in order to find the data and the total number of data, you can also find the example in StudentSerive
