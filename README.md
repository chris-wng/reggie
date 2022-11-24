# 瑞吉外卖

## 资料

视频：https://www.bilibili.com/video/BV13a411q753?spm_id_from=333.999.0.0

资料：https://www.aliyundrive.com/s/DS2XMVojBjH 


部署

    1. 导入数据库
    
    2. 配置minio
    
    3. redis安装
    
    管理端：http://localhost:8080/backend/page/login/login.html
    
    移动端：http://localhost:8080/front/page/login.html

## 项目介绍

本项目（瑞吉外卖）是专门为餐饮企业（餐厅、饭店）定制的一款软件产品，包括系统管理后台和移动端应用两部分。

其中系统管理后台主要提供给餐饮企业内部员工使用，可以对餐厅的分类、菜品、套餐、订单、员工等进行管理维护。

移动端应用主要提供给消费者使用，可以在线浏览菜品、添加购物车、下单等。

## 技术架构

1).用户层

本项目中在构建系统管理后台的前端页面，会用到H5、Vue.js、ElementUI等技术。

构建移动端应用时，会使用到微信小程序。

2).网关层

Nginx是一个服务器，主要用来作为Http服务器，部署静态资源，访问性能高。

在Nginx中还有两个比较重要的作用： 反向代理和负载均衡。

在进行项目部署时，要实现Tomcat的负载均衡，就可以通过Nginx来实现。

3).应用层

SpringBoot： 快速构建Spring项目, 采用 "约定优于配置" 的思想, 简化Spring项目的配置开发。

Spring: 统一管理项目中的各种资源(bean), 在web开发的各层中都会用到。

SpringMVC：SpringMVC是spring框架的一个模块，springmvc和spring无需通过中间整合层进行整合，可以无缝集成。

SpringSession: 主要解决在集群环境下的Session共享问题。

lombok：能以简单的注解形式来简化java代码，提高开发人员的开发效率。

Swagger： 可以自动的帮助开发人员生成接口文档，并对接口进行测试。

4).数据层

MySQL： 关系型数据库, 本项目的核心业务数据都会采用MySQL进行存储。

MybatisPlus： 本项目持久层将会使用MybatisPlus来简化开发, 基本的单表增删改查直接调用框架提供的方法即可。

Redis： 基于key-value格式存储的内存数据库, 访问速度快, 经常使用它做缓存(降低数据库访问压力, 提供访问效率), 在性能优化中会使用。

5).工具

git: 版本控制工具, 在团队协作中, 使用该工具对项目中的代码进行管理。

maven: 项目构建工具。

junit：单元测试工具，开发人员功能实现完毕后，需要通过junit对功能进行单元测试。


## 功能架构

### 移动端前台功能

手机号登录 , 微信登录 , 收件人地址管理 , 用户历史订单查询 , 菜品规格查询 , 购物车功能 , 下单 , 分类及菜品浏览。

### 系统管理后台功能

#### 管理端

餐饮企业内部员工使用。 主要功能有: 

| 模块      | 描述                                                         |
| --------- | ------------------------------------------------------------ |
| 登录/退出 | 内部员工必须登录后,才可以访问系统管理后台                    |
| 员工管理  | 管理员可以在系统后台对员工信息进行管理，包含查询、新增、编辑、禁用等功能 |
| 分类管理  | 主要对当前餐厅经营的 菜品分类 或 套餐分类 进行管理维护， 包含查询、新增、修改、删除等功能 |
| 菜品管理  | 主要维护各个分类下的菜品信息，包含查询、新增、修改、删除、启售、停售等功能 |
| 套餐管理  | 主要维护当前餐厅中的套餐信息，包含查询、新增、修改、删除、启售、停售等功能 |
| 订单明细  | 主要维护用户在移动端下的订单信息，包含查询、取消、派送、完成，以及订单报表下载等功能 |

#### 用户端

移动端应用主要提供给消费者使用。主要功能有:

| 模块        | 描述                                                         |
| ----------- | ------------------------------------------------------------ |
| 登录/退出   | 在移动端, 用户也需要登录后使用APP进行点餐                    |
| 点餐-菜单   | 在点餐界面需要展示出菜品分类/套餐分类, 并根据当前选择的分类加载其中的菜品信息, 供用户查询选择 |
| 点餐-购物车 | 用户选中的菜品就会加入用户的购物车, 主要包含 查询购物车、加入购物车、删除购物车、清空购物车等功能 |
| 订单支付    | 用户选完菜品/套餐后, 可以对购物车菜品进行结算支付, 这时就需要进行订单的支付 |
| 个人信息    | 在个人中心页面中会展示当前用户的基本信息, 用户可以管理收货地址, 也可以查询历史订单数据 |

### 角色

| 角色             | 权限操作                                                     |
| ---------------- | ------------------------------------------------------------ |
| 后台系统管理员   | 登录后台管理系统，拥有后台系统中的所有操作权限               |
| 后台系统普通员工 | 登录后台管理系统，对菜品、套餐、订单等进行管理 (不包含员工管理) |
| C端用户          | 登录移动端应用，可以浏览菜品、添加购物车、设置地址、在线下单等 |

## 功能

### 第一部分：瑞吉外卖项目

#### 1 环境搭建

①数据库搭建

| 表名     | 说明        |
| ------------- | ---------------- |
| employee      | 员工表           |
| category      | 菜品和套餐分类表 |
| dish          | 菜品表           |
| setmeal       | 套餐表           |
| setmeal_dish  | 套餐菜品关系表   |
| dish_flavor   | 菜品口味关系表   |
| user          | 用户表（C端）    |
| address_book  | 地址簿表         |
| shopping_cart | 购物车表         |
| orders        | 订单表           |
| order_detail  | 订单明细表       |

②项目搭建

后端项目

前端静态页面(WebMvcConfig.class 静态资源映射)

#### 2 后台系统登录/退出功能

登录页面存放目录 /resources/backend/page/login/login.html

登录逻辑：

    ①. 将页面提交的密码password进行md5加密处理, 得到加密后的字符串
    
    ②. 根据页面提交的用户名username查询数据库中员工数据信息
    
    ③. 如果没有查询到, 则返回登录失败结果
    
    ④. 密码比对，如果不一致, 则返回登录失败结果
    
    ⑤. 查看员工状态，如果为已禁用状态，则返回员工已禁用结果
    
    ⑥. 登录成功，将员工id存入Session, 并返回登录成功结果

登录添加一个过滤器或拦截器，判断用户是否已经完成登录，如果没有登录则返回提示信息，跳转到登录页面。

过滤器LoginCheckFilter处理逻辑如下：

    ①. 获取本次请求的URI

    ②. 判断本次请求, 是否需要登录, 才可以访问

    ③. 如果不需要，则直接放行

    ④. 判断登录状态，如果已登录，则直接放行

    ⑤. 如果未登录, 则返回未登录结果

退出逻辑：

    ①. 清理Session中的用户id

    ②. 返回结果

#### 3 员工管理 employee(员工表)

##### 3.1 新增员工


    A. 点击"保存"按钮, 页面发送ajax请求，将新增员工页面中输入的数据以json的形式提交到服务端, 请求方式POST, 请求路径 /employee

    B. 服务端Controller接收页面提交的数据并调用Service将数据进行保存

    C. Service调用Mapper操作数据库，保存数据


##### 3.2 员工信息分页查询


    1). 页面发送ajax请求，将分页查询参数(page、pageSize、name)提交到服务端
    
    2). 服务端Controller接收页面提交的数据, 并组装条件调用Service查询数据
    
    3). Service调用Mapper操作数据库，查询分页数据
    
    4). Controller将查询到的分页数据, 响应给前端页面
    
    5). 页面接收到分页数据, 并通过ElementUI的Table组件展示到页面上

##### 3.3 启用、禁用员工账号

    1). 页面发送ajax请求，将参数(id、status)提交到服务端
    
    2). 服务端Controller接收页面提交的数据并调用Service更新数据
    
    3). Service调用Mapper操作数据库

    
    ** bug: js在对长度较长的长整型数据进行处理时，会损失精度 **

    1). 提供对象转换器JacksonObjectMapper，基于Jackson进行Java对象到json数据的转换
    
    2). 在WebMvcConfig配置类中扩展Spring mvc的消息转换器，在此消息转换器中使用提供的对象转换器进行Java对象到json数据的转换

##### 3.4 编辑工具信息  

    实现的方法
    
    A. 根据ID查询, 用于页面数据回显
    
    B. 保存修改
    
    流程：
    
    1). 点击编辑按钮时，页面跳转到add.html，并在url中携带参数[员工id]
    
    2). 在add.html页面获取url中的参数[员工id]
    
    3). 发送ajax请求，请求服务端，同时提交员工id参数
    
    4). 服务端接收请求，根据员工id查询员工信息，将员工信息以json形式响应给页面
      
    5). 页面接收服务端响应的json数据，通过VUE的数据绑定进行员工信息回显
    
    6). 点击保存按钮，发送ajax请求，将页面中的员工信息以json方式提交给服务端
    
    7). 服务端接收员工信息，并进行处理，完成后给页面响应
    
    8). 页面接收到服务端响应信息后进行相应处理
    
#### 4 公共字段自动填充

问题：

    A. 在新增数据时, 将createTime、updateTime 设置为当前时间, createUser、updateUser设置为当前登录用户ID。
    
    B. 在更新数据时, 将updateTime 设置为当前时间, updateUser设置为当前登录用户ID。
    
步骤：
    
    1、在实体类的属性上加入@TableField注解，指定自动填充的策略。
    
    2、按照框架要求编写元数据对象处理器，在此类中统一为公共字段赋值，此类需要实现MetaObjectHandler接口。
    
问题：如何获取当前登录用户的id？

    客户端发送的每次http请求，对应的在服务端都会分配一个新的线程来处理，在处理过程中涉及到下面类中的方法都属于相同的一个线程：
    
    1). LoginCheckFilter的doFilter方法
    
    2). EmployeeController的update方法
    
    3). MyMetaObjectHandler的updateFill方法
    
    我们可以在上述类的方法中加入如下代码(获取当前线程ID,并输出):
    
        long id = Thread.currentThread().getId();
        
        log.info("线程id为：{}",id);
    
    结论：执行编辑员工功能进行验证，通过观察控制台输出可以发现，一次请求对应的线程id是相同的：
    
    经过上述的分析之后,发现可以使用JDK提供的ThreadLocal类, 来解决此问题,
    
ThreadLocal
    
    ThreadLocal并不是一个Thread，而是Thread的局部变量。当使用ThreadLocal维护变量时，ThreadLocal为每个使用该变量的线程提供独立的变量副本，所以每一个线程都可以独立地改变自己的副本，而不会影响其它线程所对应的副本。
    
    ThreadLocal为每个线程提供单独一份存储空间，具有线程隔离的效果，只有在线程内才能获取到对应的值，线程外则不能访问当前线程对应的值。
        
ThreadLocal常用方法：

    A. public void set(T value) : 设置当前线程的线程局部变量的值
    
    B. public T get() : 返回当前线程所对应的线程局部变量的值
    
    C. public void remove() : 删除当前线程所对应的线程局部变量的值 
    
    *** 结论 ***
    
    可以在LoginCheckFilter的doFilter方法中获取当前登录用户id，并调用ThreadLocal的set方法来设置当前线程的线程局部变量的值（用户id）
    
    然后在MyMetaObjectHandler的updateFill方法中调用ThreadLocal的get方法来获得当前线程所对应的线程局部变量的值（用户id）
     
    如果在后续的操作中, 我们需要在Controller / Service中要使用当前登录用户的ID, 可以直接从ThreadLocal直接获取。
    
问题：如何获取当前登录用户的id？

    1). 编写BaseContext工具类，基于ThreadLocal封装的工具类
    
    2). 在LoginCheckFilter的doFilter方法中调用BaseContext来设置当前登录用户的id
    
    3). 在MyMetaObjectHandler的方法中调用BaseContext获取登录用户的id

#### 5 分类管理 category(分类表)

##### 5.1 新增分类

    1). 在页面(backend/page/category/list.html)的新增分类表单中填写数据，点击 "确定" 发送ajax请求，将新增分类窗口输入的数据以json形式提交到服务端
    
    2). 服务端Controller接收页面提交的数据并调用Service将数据进行保存
    
    3). Service调用Mapper操作数据库，保存数据

##### 5.2 分类信息分页查询

    1). 页面发送ajax请求，将分页查询参数(page、pageSize)提交到服务端
    
    2). 服务端Controller接收页面提交的数据并调用Service查询数据
    
    3). Service调用Mapper操作数据库，查询分页数据
    
    4). Controller将查询到的分页数据响应给页面
    
    5). 页面接收到分页数据并通过ElementUI的Table组件展示到页面上

##### 5.3 删除分类

    1). 点击删除，页面发送ajax请求，将参数(id)提交到服务端
    
    2). 服务端Controller接收页面提交的数据并调用Service删除数据
    
    3). Service调用Mapper操作数据库
    
    注意：
    
    - 根据当前分类的ID，查询该分类下是否存在菜品dish(菜品表) 和 setmeal(套餐表)，如果存在，则提示错误信息
    
    - 根据当前分类的ID，查询该分类下是否存在套餐setmeal(套餐表)，如果存在，则提示错误信息
    
##### 5.4 修改分类  

##### 5.5 列表查询

#### 6 菜品管理

##### 6.1 文件上传下载

文件上传时，对页面的form表单有如下要求：

| 表单属性 | 取值                | 说明                      |
| -------- | ------------------- | ------------------------- |
| method   | post                | 必须选择post方式提交      |
| enctype  | multipart/form-data | 采用multipart格式上传文件 |
| type     | file                | 使用input的file控件上传   |

    <form method="post" action="/common/upload" enctype="multipart/form-data">
        <input name="myFile" type="file"  />
        <input type="submit" value="提交" /> 
    </form>

组件：

    - commons-fileupload
    
    - commons-io
    
上传逻辑：

    1). 获取文件的原始文件名, 通过原始文件名获取文件后缀
    
    2). 通过UUID重新声明文件名, 文件名称重复造成文件覆盖
    
    3). 创建文件存放目录
    
    4). 将上传的临时文件转存到指定位置

通过浏览器进行文件下载，通常有两种表现形式：

    - 以附件形式下载，弹出保存对话框，将文件保存到指定磁盘目录
    
    - 直接在浏览器中打开

下载逻辑：

    1). 定义输入流，通过输入流读取文件内容
    
    2). 通过response对象，获取到输出流
    
    3). 通过response对象设置响应数据格式(image/jpeg)
    
    4). 通过输入流读取文件数据，然后通过上述的输出流写回浏览器
    
    5). 关闭资源
    
上传和下载逻辑优化：minio

    单机运行：minio.exe server D:\minioDate 

##### 6.2 新增菜品

    1). 点击新建菜品按钮, 访问页面(backend/page/food/add.html), 页面加载时发送ajax请求，请求服务端获取菜品分类数据并展示到下拉框中

    2). 页面发送请求进行图片上传，请求服务端将图片保存到服务器(上传功能已实现)
    
    3). 页面发送请求进行图片下载，将上传的图片进行回显(下载功能已实现)
    
    4). 点击保存按钮，发送ajax请求，将菜品相关数据以json形式提交到服务端
    
新增菜品操作了两张表，那么为了保证数据的一致性，需要在方法上加上注解 @Transactional来控制事务。

    @Transactional使用时会有失效的情况：
    
    ① 首先要看数据库本身对应的库、表所设置的引擎是什么。MyIsam不支持事务，如果需要，则必须改为InnoDB
    
    ② @Transactional所注解的方法必须时public
    
    ③ 一个类中的A方法去调用B方法，@Transactional注解在B方法上是不起作用的
    
    ④ @Transactional所注解的方法所在的类，是否已经被注解@Service或@Component等
    
    ⑤ 异常被你的 catch“吃了”导致@Transactional失效，注解的方法不能使用try，catch
    
    ⑥ 你的异常类型不是unchecked异常
    
    @Transactional使用的技巧：
    
    一般情况下，单独在service层或者dao层用@Transactional注解一个方法，避免上述失效的情况，在上一层（controller或者service层）调用时进行try，catch，可以有效的使用@Transactional进行事务管理

##### 6.3 菜品信息分页查询

    1). 构造分页条件对象
    
    2). 构建查询及排序条件
    
    3). 执行分页条件查询
    
    4). 遍历分页查询列表数据，根据分类ID查询分类信息，从而获取该菜品的分类名称
    
    5). 封装数据并返回

##### 6.4  修改菜品
    
    A. 根据ID查询菜品的基本信息 
    
    B. 根据菜品的ID查询菜品口味列表数据
    
    C. 组装数据并返回
    
    D. 点击保存，修改成功
    
##### 6.5  删除菜品

    A. 根据ID查询菜品的基本信息 
        
    B. 根据菜品的ID查询菜品口味列表数据
    
    C. 删除菜品口味列表数据
    
    D. 删除菜品基本信息
    
##### 6.6  菜品批量删除

##### 6.7  菜品停售

##### 6.8  菜品批量停售

##### 6.9  列表查询
    
#### 7 新增套餐

涉及的表格

    | 表           | 说明           | 备注                                               |
    | ------------ | -------------- | -------------------------------------------------- |
    | setmeal      | 套餐表         | 存储套餐的基本信息                                 |
    | setmeal_dish | 套餐菜品关系表 | 存储套餐关联的菜品的信息(一个套餐可以关联多个菜品) |

##### 7.1 新增套餐

    A. 根据传递的参数,查询套餐分类列表
    
    B. 根据传递的参数,查询菜品分类列表
    
    C. 图片上传
    
    D. 图片下载展示
    
    E. 根据菜品分类ID,查询菜品列表
    
    F. 保存套餐信息

##### 7.2 分页查询套餐
    
    1). 构建分页条件对象
    
    2). 构建查询条件对象，如果传递了套餐名称，根据套餐名称模糊查询， 并对结果按修改时间降序排序
    
    3). 执行分页查询
    
    4). 组装数据并返回


##### 7.3 修改套餐

##### 7.4 删除套餐

##### 7.5 菜品停售

##### 7.6 根据条件查询套餐数据

#### 8 移动端开发

##### 8.1 阿里云短信服务介绍

    | 场景     | 案例                                                         |
    | -------- | ------------------------------------------------------------ |
    | 验证码   | APP、网站注册账号，向手机下发验证码； 登录账户、异地登录时的安全提醒； 找回密码时的安全验证； 支付认证、身份校验、手机绑定等。 |
    | 短信通知 | 向注册用户下发系统相关信息，包括： 升级或维护、服务开通、价格调整、 订单确认、物流动态、消费确认、 支付通知等普通通知短信。 |
    | 推广短信 | 向注册用户和潜在客户发送通知和推广信息，包括促销活动通知、业务推广等商品与活动的推广信息。增加企业产品曝光率、提高产品的知名度。 |
    
    阿里云短信服务官方网站： https://www.aliyun.com/product/sms?spm=5176.19720258.J_8058803260.52.5c432c4a11Dcwf
    
    注册账号：阿里云官网：https://www.aliyun.com/
    
步骤：

    1. 申请签名：签名是短信中能代表发送者属性的字段。
    
    2. 设置短信模板
    
    3. 设置AccessKey：访问阿里云 API 的密钥，具有账户的完全权限
    
    ---继续使用AccessKey
    
    如果选择的是该选项，我们创建的是阿里云账号的AccessKey，是具有账户的完全权限，有了这个AccessKey以后，我们就可以通过API调用阿里云的服务，不仅是短信服务，其他服务也可以调用。 
    
    相对来说，并不安全，当前的AccessKey泄露，会影响到我当前账户的其他云服务。
    
    ---开始使用子用户AccessKey
    
    可以创建一个子用户,这个子用户我们可以分配比较低的权限,比如仅分配短信发送的权限，不具备操作其他的服务的权限，即使这个AccessKey泄漏了,也不会影响其他的云服务, 相对安全。
    
    4. 配置权限
    
代码开发官方文档: https://help.aliyun.com/product/44282.html?spm=5176.12212571.help.dexternal.57a91cbewHHjKq
    
    1. 导入坐标：
    
        <dependency>
            <groupId>com.aliyun</groupId>
            <artifactId>aliyun-java-sdk-core</artifactId>
            <version>4.5.16</version>
        </dependency>
        <dependency>
            <groupId>com.aliyun</groupId>
            <artifactId>aliyun-java-sdk-dysmsapi</artifactId>
            <version>2.1.0</version>
        </dependency>
        
    2. 短信发送工具类：将官方提供的main方法封装为一个工具类 ：SMSUtils
    
##### 8.1 短信发送验证码

为了方便用户登录，移动端通常都会提供通过手机验证码登录的功能。手机验证码登录有如下优点：

    1). 方便快捷，无需注册，直接登录
    
    2). 使用短信验证码作为登录凭证，无需记忆密码
    
    3). 安全  
   
##### 8.2  手机验证码登录  user表

登录流程：

    输入手机号 > 获取验证码 > 输入验证码 > 点击登录 > 登录成功
    

    1). 获取前端传递的手机号和验证码
    
    2). 从Session中获取到手机号对应的正确的验证码
    
    3). 进行验证码的比对 , 如果比对失败, 直接返回错误信息
    
    4). 如果比对成功, 需要根据手机号查询当前用户, 如果用户不存在, 则自动注册一个新用户
    
    5). 将登录用户的ID存储Session中

##### 8.3 地址簿管理  address_book表

###### 8.3.1 新增地址

###### 8.3.2 地址列表查询

###### 8.3.3 设置默认地址

###### 8.3.4 编辑地址

###### 8.3.5 删除地址

##### 8.4 菜品展示

    A. 根据分类ID查询菜品列表(包含菜品口味列表)
    
    B. 根据分类ID查询套餐列表

##### 8.5 购物车  shopping_cart表

###### 8.5.1 添加购物车
    
    A. 获取当前登录用户，为购物车对象赋值
    
    B. 根据当前登录用户ID 及 本次添加的菜品ID/套餐ID，查询购物车数据是否存在
    
    C. 如果已经存在，就在原来数量基础上加1
    
    D. 如果不存在，则添加到购物车，数量默认就是1

###### 8.5.2 查询购物车

###### 8.5.3 清空购物车

###### 8.5.4 减少购物车数量

orders表和order_detail表

    A. 获得当前用户id, 查询当前用户的购物车数据
    
    B. 根据当前登录用户id, 查询用户数据
    
    C. 根据地址ID, 查询地址数据
    
    D. 组装订单明细数据, 批量保存订单明细 
    
    E. 组装订单数据, 批量保存订单数据
    
    F. 删除当前用户的购物车列表数据

	上述逻辑处理中，计算购物车商品的总金额时，为保证我们每一次执行的累加计算是一个原子操作，我们这里用到了JDK中提供的一个原子类 AtomicInteger
	
##### 8.6 下单  orders表，order_detail表

###### 8.6.1 下单

###### 8.6.2 查看列表

###### 8.6.3 修改状态

###### 8.6.4 再来一单

##### 8.7 退出

### 第二部分： 瑞吉外卖项目优化篇

问题：用户数据量大，系统访问量大，频繁访问数据库，系统性能下降，用户体验差

#### 1 缓存优化

##### 1.1环境搭建

导入相关坐标：

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-redis</artifactId>
        </dependency>
        
配置文件：

    spring:
      redis:
        host: 127.0.0.1
        port: 6379
        
配置类：RedisConfig

模板：RedisUtil

##### 1.2 缓存短信验证

    1. 在UserController中注入RedisTemplate对象，操作Redis
    
    2. 在UserController的sendMsg方法中，将随机生成的验证码缓存到Redis中，并设置有效期
    
    3. 在UserController的login方法中，从Redis中获取缓存的验证码，如果登陆成功则删除Rdeis中的验证码

##### 1.3 缓存菜品数据

    1. 在DishController的list方法中，先从Redis中获取菜品数据，如果有则直接返回，无需查询，如果没有查询数据库，并将查询到的菜品放入Redis
    
    2. 在DishController的save、delete、update、status方法中，加入清理缓存的逻辑

##### 1.4 Spring Cache

##### 1.5 Spring Cache

Spring Cache是一个框架，实现了基于注解的缓存功能

针对不同的缓存技术需要实现不同的CacheManager

    EhCacheCacheManager 使用EhCache作为缓存技术
    
    GuavaCacheManager 使用Google的GuavaCache作为缓存技术
    
    RedisCacheManager 使用Redis作为缓存技术
    
注解
    
    @EnableCaching 开启缓存注解功能---启动类
    
    @Cacheable 在方法执行前spring先查看缓存中是否含有数据，如果有数据，则直接返回缓存数据，没有数据，调用方法并将方法返回值放到缓存
    
        value 缓存的名称
        
        key 缓存的key
        
        condition 条件，满足条件时才缓存数据
        
        unless 满足条件则不缓存
    
    @CachePut 将方法的返回值放到缓存中 
        
        @CachePut(value="缓存的名称,每个缓存名称下面有多个key",key="缓存的key")
        
        key: #result 方法返回的结果 #root 
    
    @CacheEvict 将一条或多条数据从缓存中删除
    
坐标：

         <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-redis</artifactId>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-cache</artifactId>
        </dependency>

application.yml

    spring:
      cache:
        redis:
          time-to-live: 18000000 #设置过期时间30分钟

##### 1.6 缓存套餐数据  

#### 2 读写分离

问题：读写所有压力都有一台数据库承担，压力大，数据库服务器磁盘损坏则数据丢失，单点故障

##### 2.1 MySQL主从复制

MySQL主从复制是一个异步的复制过程，底层是数据库自带的二进制日志功能。

即一台或多台MySQL数据库从另一台MySQL数据库进行日志的复制，然后再解析日志并应用到自身，最终实现从库和主库的数据保持一致

过程：
    
    master将改变的记录到二进制日志
    
    slave将master的二进制日志拷贝到他的中继日志
    
    slave重做中继日志中的时间，将改变应用到自己的数据库中
  
资料：

    centos7： http://mirrors.aliyun.com/centos/7/isos/x86_64/
    
    electerm： https://electerm.html5beta.com/
    
    MySQL-5.7包：https://mirrors.huaweicloud.com/mysql/Downloads/MySQL-5.7/
    
    安装：https://blog.csdn.net/Linrp/article/details/123203433?ops_request_misc=%257B%2522request%255Fid%2522%253A%2522165180210616782184653825%2522%252C%2522scm%2522%253A%252220140713.130102334.pc%255Fall.%2522%257D&request_id=165180210616782184653825&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~all~first_rank_ecpm_v1~rank_v31_ecpm-5-123203433.142^v9^pc_search_result_cache,157^v4^control&utm_term=linux+mysql5.7%E5%AE%89%E8%A3%85%E5%8C%85&spm=1018.2226.3001.4187
    
    mysql建立外部连接-》防火墙问题：
    
        firewall-cmd --state   查看防火墙状态，防火墙是开启状态。
        
        firewall-cmd --list-all    查看开放端口，3306没有包含在里面。
        
        firewall-cmd --zone=public --add-port=3306/tcp --permanent      于是执行此命令开放3306端口号
        
        firewall-cmd --reload       重启防火墙

master配置
    
    1. 修改MySQL数据库的配置文件/etc/my.cnf
    
        login-bin=mysql-bin #启动二进制日志
        
        server-id=100 服务器唯一ID
        
    2. 重启MySQL服务：systemctl restart mysql   
     
    3. 登录MySQL，建立复制时所需要的用户权限即slave必须被master授权具有该权限的用户，才能通过该用户复制
    
        ./mysql -uroot -p123456
        
        GRANT REPLICATION SLAVE ON *.* to 'zhangsan'@'%' identified by '123456'
        
        show master status; 查看master状态
            
slave配置   
     
     1. 修改MySQL数据库的配置文件/etc/my.cnf
             
         server-id=100 服务器唯一ID
             
     2. 重启MySQL服务：systemctl restart mysql
     
     3. 登录MySQL
     
        ./mysql -uroot -p123456
        
        change master to master_host='192.168.10.147',master_user='zhangsan',master_password='123456',master_log_file
        ='mysql-bin.000003',master_log_pos=2369;
        
        启动 start slave;
        
        查看状态  show slave status\G;


##### 2.2 读写分离

    主库负责处理事务的增删改操作
    
    从库负责处理查询操作

Sharding-JDBC：客户端直连数据库，以jar包形式提供服务，无需额外部署和依赖

1. 适用于任何基于JDBC的ORM框架，如JPA,Hibernate,Mybatis,JDBC,Spring JDBC Template

2. 支持任何第三方的数据路连接池，如DBCP,C3P0,Druid

3. 支持任意实现JDBC规范的数据库

使用：

    1. 导入坐标
          
        <dependency>
        
            <groupId>org.apache.shardingsphere</groupId>
            
            <artifactId>sharding-jdbc-spring-boot-starter</artifactId>
            
            <version>4.0.0-RC1</version>
            
        </dependency>
    
    2.在配置文件中配置读写分离规则 见application.yml
    
    3.在配置文件中配置允许bean定义覆盖配置项 见application.yml
    
##### 2.3 Nginx

Nginx是一款轻量级web服务器/反向代理服务器及电子邮件（IMAP/POP3）代理服务器。

稳定版 1.20.1 

下载地址：http://nginx.org/en/download.html

安装步骤：
    
    1. 安装依赖：yum install gcc gcc-c++ pcre pcre-devel zlib zlib-devel openssl openssl-devel -y

    2. 下载Nginx
    
    3. 解压：tar -zxvf nginx-1.16.1.tar.gz
    
    4. cd nginx-1.16.1
    
    5. ./configure --prefix=/ruanjian/nginx
    
    6. 编译安装 make && make install
    
Nginx目录结构：

    - conf/nginx.conf  nginx配置文件
    
    - html 存放静态文件
    
    - logs
    
    - sbin/nginx 二进制文件，用于启动、停止nginx服务   
    
常用命令：

    版本号 ./nginx -v 
    
    检查nginx.conf配置是否有误：./nginx -t
    
    查看进程：ps -ef |grep nginx
    
    启动：./nginx
    
    停止： ./nginx -s stop 
    
    重新加载配置文件： ./nginx -s reload
    
nginx.conf

    - 全局块 和nginx运行相关的全局配置
    
    - events块 和网络连接相关的配置
    
    - HTTP块 代理、缓存、日志记录、虚拟主机配置
    
        - HTTP全局块
        
        - server块（可以配置多个）
            
            - server全局块
            
            - location块
            
静态资源：

        server {
            listen       80 ;                  # 监听端口
            server_name  localhost;            # 服务器名称

            location / {                       # 匹配客户端请求url
                root   html;                   # 指定静态资源根目录
                index  index.html index.htm;   # 指定默认首页
            }
        }
            
反向代理：
    
    正向代理：在客户端设置代理服务器，通过代理服务器转发请求，最终访问目标服务器
    
    反向代理：用户直接访问反向代理器就可以获得目标服务器的资源，反向代理服务器将请求转发给目标服务器
    
负载均衡：

    将用户请求根据对应的负载均衡算法分发到应用集群中的一台服务器进行处理
    
    upstream targetserver{                  #upstream指令可以定义一组服务器
        server 192.168.10.110:8080;
        server 192.168.10.110:8081;
    }
    
    server {
        listen       80 ;                  # 监听端口
        server_name  localhost;            # 服务器名称

        location / {                       # 匹配客户端请求url
           proxy_pass http://targetserver;
        }
    }
    
    策略：
    
        轮询          默认
        
        weight       权重
        
        ip_hash      依据IP分配方式
        
        least_conn    依据最少连接方式
        
        url_hash      依据url分配方式
        
        fair          依据相应时间方式
        
#### 3 前后端分离开发

##### 3.1 前后端分离开发

##### 3.2 YApi

##### 3.3 Swagger

    1. 导入knife4j的maven坐标
    
        <dependency>
        
            <groupId>com.github.xiaoymin</groupId>
            
            <artifactId>knife4j-spring-boot-starter</artifactId>
            
            <version>3.0.2</version>
            
        </dependency>
    
    2. 导入knife4j的配置类 WebMvcConfig
    
    3. 设置静态资源，否则接口文档页面无法访问 WebMvcConfig
    
    4. 在LoginCheckFilter中设置不需要处理的请求路径








