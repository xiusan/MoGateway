package com.mogateway.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 创建用户:杨辽
 * 创建时间: 2018-04-08 11:40
 * 描   述:
 **/
public class ProcessT {

    public final Logger logger = LoggerFactory.getLogger(this.getClass());

    protected final static Object OBJECT = new Object();

    public static Lock lock = new ReentrantLock();


}
