package com.epam.spring.constants;

public interface SqlConstants {
    //ddl (Data Definition Language)
    String CREATE_TABLE_CATS = "create table cats (\n" +
            "    id bigint not null auto_increment,\n" +
            "    name varchar(255) not null,\n" +
            "    age integer not null,\n" +
            "    primary key (id)\n" +
            ");";
    String DROP_TABLE_CATS = "drop table cats cascade";

    //dml (Data Manipulation Language)
    String POPULATE_TABLE_CATS = "insert into cats (name, age) values\n" +
            "('kotik1', 2),\n" +
            "('kotik2', 12),\n" +
            "('kotik3', 7);" ;

    String FIND_CAT_BY_ID_NAMED = "select * from cats where id = :id";
    String FIND_CAT_BY_ID = "select * from cats where id = ?";
    String FIND_ALL_CATS = "select * from cats";
    String SAVE_CAT = "insert into cats (name, age) values (:name, :age)";

}
