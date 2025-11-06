package com.tugra.handler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Exception<T> {

    private String localhost;

    private String path;

    private T message;

}
