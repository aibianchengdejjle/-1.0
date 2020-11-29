<template>
  <!--引入container布局-->
  <el-container class="home-container">
    <!--头部-->
    <el-header>
      <div>
        <img src="../assets/liqing.jpg" alt="" class="headImg">
        <span class="headSpan">个人运动平台</span>
      </div>
      <el-button type="info" @click="logout">安全退出</el-button>
    </el-header>
    <!--主体-->
    <el-container>
      <!--侧边布局-->
      <el-aside width="isCollapse?64px:200px" class="headAside">
        <!--伸缩按钮-->
        <div class="toggle-button" @click="toggleCollapase">点我收缩</div>
        <!--侧边栏菜单区 unique-opened="true" 只保持一个菜单展开 router开启路由 active-text-color 颜色-->
        <el-menu background-color="#545c64" text-color="#fff" active-text-color="#409eff" unique-opened :collapse="isCollapse"
                 :collapse-transition="false"  :router="true" :default-active="activePath">
          <!--遍历菜单-->
          <el-submenu :index="item.id+''" v-for="item in menuList" :key="item.id">
            <template slot="title">
              <i :class="iconsObject[item.id]"></i>
              <span>{{item.title}}</span>
            </template>
            <el-menu-item  :index="it.path+''" v-for="it in item.slist" :key="it.id"  @click="saveNavState(it.path+'')">
              <template slot="title" >
                <i :class="iconsObject[it.id]"></i>
                <span>{{it.title}}</span>
              </template>
            </el-menu-item>
          </el-submenu>
        </el-menu>
      </el-aside>
      <!--主体布局-->
      <el-main>
        <!--路由占位符-->
        <router-view></router-view>
      </el-main>
    </el-container>
  </el-container>

</template>

<script>
  export default {
    name: '',
    data(){
      return{
        //菜单列表
        menuList:[],
        isCollapse:false,   // 伸缩属性
        iconsObject: {
          '100':'iconfont iconguanliyuan',
          '200':'iconfont iconsport',
          '101':'iconfont icondenglu',
          '102':'iconfont iconmima',
          '103':'iconfont iconsport',
          '104':'iconfont iconshangpin',
          '201':'iconfont iconshu',
          '202':'iconfont iconkaluli',
          '203':'iconfont iconshiwu',
          '204':'iconfont icondenglu',
        },
        activePath:'/welcome', //设置进入主页的默认路径
      }
    },
    /* 页面一加载就能onload事件*/
    created(){
      this.getMenuList();
      this.activePath=window.sessionStorage.getItem("activePath")   //取出里的path 动态修改activipath 我们只保留最后一次的选择路径
    },
    methods:{
      logout(){
        window.sessionStorage.clear()   /* 清楚session */
        this.$router.push("/Login")   //回到首页
      },
      // 获取导航菜单方法
      async getMenuList(){
        /*console.log("getList")*/
        const {data:res}=await this.$http.get("menus");
        if(res.flag!=200){
          return this.$message.error();
        }
        this.menuList=res.data;  //访问成功的回填
      },
      // 控制侧边栏伸缩
      toggleCollapase(){
        this.isCollapse=!this.isCollapse
      },
      //在二级菜单下的默认路径 保存路径  通过sessino来保存这个路径
       saveNavState(activePath){
        window.sessionStorage.setItem('activePath',activePath);// 存放点击的二级菜单
        this.activePath=activePath;
      }
    },
    //路由挂载
    beforeRouteEnter:(to,from,next)=>{
      if(to.path=='/Login') return next();
      const flagStr=window.sessionStorage.getItem("user")
      if(!flagStr)return next("/Login")
      return next()
    }
  }
</script>

<style  scoped>
  .home-container{
    height: 100%;
  }
  /*头部样式*/
  .el-header{
    background-color: #373d41;
    display: flex;
    justify-content: space-between;
    padding-left: 0%;
    align-items: center;
    color: #fff;
    font-size: 20px;
    display: flex;
    align-items: center;
  }
  .headSpan{
    margin-left: 15px;
  }

  /*侧边栏样式*/
  .headAside{
    background-color: #333744;
  }
  .el-menu{
     border-right:none;
   }
  /*主体样式*/
  .el-main{
    background-color: #eaedf1;
  }
  .headImg{
    width: 55px;
    height: 55px;
  }
  /* 按钮样式*/
  .toggle-Button{
    background-color: #00eeee;
    font-size: 10px;
    line-height: 24px;
    color: white;
    text-align: center;
    letter-spacing: 0.2em;
    cursor:pointer;
  }
</style>
