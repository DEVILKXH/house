# python
# -*- coding: utf-8 -*-

import tensorflow as tf
import numpy as np
import sys
import json
import pymysql

def getresult(city,brand):
    db = pymysql.connect(host="39.108.12.197", user="root", password="volcano", db="house", port=3306,use_unicode=True, charset="utf8")
    cur = db.cursor()
    sql = '''SELECT city,brand,area,avg(price) FROM house
        WHERE type = 'old' and city='%s' and brand = '%s'
        GROUP BY city,brand,area
        order BY city,brand,area''' %(city,brand)
    cur.execute(sql)
    results = cur.fetchall()    #获取查询的所有记录
    return results

# 线性模型 y=bx+a
def model(x, b, a):
    return tf.multiply(x, b) + a


# 归一化函数
def normalize(arr):
    arr_min = np.min(arr)
    arr_max = np.max(arr)
    arr_out = []
    for item in arr:
        out = np.divide(np.subtract(item, arr_min), np.subtract(arr_max, arr_min))
        arr_out = np.append(arr_out, np.array(out))
    return arr_out

if __name__ == "__main__":
    # print(sys.argv)
    sess = tf.Session()
    city = sys.argv[1]
    brand = sys.argv[2]
    results = getresult(city,brand);
    trX_i = []
    trY_i = []
    for row in results:
        trX_i.append(float(row[2]))
        trY_i.append(float(row[3]))
    # 原始数据
    # trX_i = [1100., 1400., 1425., 1550., 1600., 1700., 1700., 1875., 2350., 2450.]
    #trY_i = [199000., 245000., 319000., 240000., 312000., 279000., 310000., 308000., 405000., 324000.]
    # 数据归一化
    trX = normalize(trX_i)
    trY = normalize(trY_i)

    X = tf.placeholder(tf.float32)
    Y = tf.placeholder(tf.float32)

    # 设一个权重变量b，和一个偏差变量a
    b = tf.Variable(0.0, name="weights")
    # create a variable for biases
    a = tf.Variable(0.0, name="biases")
    y_model = model(X, b, a)

    # 损失函数
    loss = tf.multiply(tf.square(Y - y_model), 0.5)

    # 梯度下降
    train_op = tf.train.GradientDescentOptimizer(0.01).minimize(loss)

    init = tf.global_variables_initializer()
    sess.run(init)

    # 训练数据
    for i in range(500):
        for (x, y) in zip(trX, trY):
            output = sess.run(train_op, feed_dict={X: x, Y: y})

    print(str(sess.run(b)) + '\n' + str(sess.run(a)))