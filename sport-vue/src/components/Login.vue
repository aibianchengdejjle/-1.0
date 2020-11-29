<template>
  <div class="login_container">
    <!--登录块-->
    <div class="login_box">
      <!--头像区-->
      <div class="avatar_box">
        <img src="../assets/logo.png" alt="">
      </div>
      <!--表单区域-->
      <el-form ref="loginFormRef" :model="loginForm" class="loginForm" label-width="0px" :rules="logniRules">
        <!--用户名-->
        <el-form-item prop="username">
          <el-input v-model="loginForm.username" prefix-icon="iconfont icondenglu"></el-input>
        </el-form-item>
        <!--密码-->
        <el-form-item prop="password">
          <el-input v-model="loginForm.password" type="password" prefix-icon="iconfont iconmima"></el-input>
        </el-form-item>
        <!--按钮-->
        <el-form-item class="btns">
          <el-button type="primary" @click="login">登录</el-button>
          <el-button type="info" @click="resetLoginForm()">重置</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script>
  export default {
    /*返回数据 */
    data(){
      return{
        loginForm:{
          /*表单数据对象*/
          username:"admin",
          password:"123456"
        },
        /* 表单校验 */
        logniRules:{
          username:[
            { required: true, message: "请输入用户名", trigger: "blur" }, /*必须验证 */
            { min: 5, max: 8, message: "长度在 5 到 8 个字符", trigger: "blur" }/* 长度杨正*/
          ],
          password:[
            { required: true, message: "请输入用户密码", trigger: "blur" }, /*必须验证 */
            { min: 6, max: 8, message: "密码为 6~8 位", trigger: "blur" }/* 长度杨正*/
          ]
        },
      }
    },
    methods:{
      /*重置表单内容*/
      resetLoginForm(){
        this.$refs.loginFormRef.resetFields();
      },
      // 登录方法
      login(){
       /* console.log("这是登录");*/
        this.$refs.loginFormRef.validate(async valid =>{ // valid验证是否成功 如果成功valid 就是true 否则就是false  并且这里是跨域请求
           if(!valid)
              return;
             const {data:res}=await this.$http.post("login",this.loginForm); // 把请求路径和表单的内容都提交过去了
             if(res.flag=="ok"){
               this.$message.success("登陆成功！！！");  /*  提示是否成功*/
               window.sessionStorage.setItem("user",res.user); /*存储user对象  */
               this.$router.push({ path: "/home"});   /*完成页面的跳转  */
               console.log(res.user);
             }else {
               this.$message.error("登录失败！！！");
             }
        })
      }
    }
  }
</script>
<!--样式-->
<style scoped>
  /* 根节点样式*/
  .login_container {
    background-color: #2b4b6b;
    height: 100%;
  }
  /* 登录框的样式 */
  .login_box {
    width: 450px;
    height: 300px;
    background-color: #fff;
    border-radius: 3px;
    position: absolute; /*绝对定位*/
    left: 50%;
    top: 50%;
    transform: translate(-50%, -50%);
  }
    /*头像区的样式 */
    .avatar_box{
      width: 130px;
      height: 130px;
      border: 1px;
      border-radius: 50%;
      padding: 5px;
      box-shadow: 0 0 10px #ddd;
      position: absolute;
      left: 50%;
      transform: translate(-50%,-50%);
      background-color: #0ee;
    }
    /*图片样式*/
      img{
         width: 100%;
        height: 100%;
        border-radius: 50%;
        background-color: #eee;
      }
  .btns{
    display: flex;
    justify-content: flex-end;
  }
  .loginForm{
    position: absolute;
    bottom: 0%;
    width: 100%;
    padding-left: 10px;
    padding-right: 10px;
    box-sizing: border-box;
  }
</style>
