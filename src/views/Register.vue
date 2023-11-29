<template>
<div class="wrapper">
  <div style="margin: 100px auto; background-color: #fff; width: 350px; height: 550px; padding: 20px; border-radius: 10px">
    <div style="margin: 20px 0;text-align: center; font-size: 24px"><b>注册</b></div>
    <el-form :model="user" :rules="rules" ref="userForm">
      <el-form-item prop="username">
        <el-input size="medium" style="margin: 10px 0" prefix-icon="el-icon-user" placeholder="请输入用户名" v-model="user.username"></el-input>
      </el-form-item>
      <el-form-item prop="password">
        <el-input size="medium" style="margin: 10px 0" prefix-icon="el-icon-lock" placeholder="请输入密码" v-model="user.password" show-password></el-input>
      </el-form-item>
      <el-form-item prop="confirmPassword">
        <el-input size="medium" style="margin: 10px 0" prefix-icon="el-icon-lock" placeholder="请确认密码" v-model="user.confirmPassword" show-password></el-input>
      </el-form-item>
      <el-form-item prop="email">
        <el-input size="medium" style="margin: 10px 0" prefix-icon="el-icon-lock" placeholder="请输入邮箱" v-model="user.email" ></el-input>
      </el-form-item>
      <el-form-item prop="phone">
        <el-input size="medium" style="margin: 10px 0" prefix-icon="el-icon-lock" placeholder="请输入手机号" v-model="user.phone" ></el-input>
      </el-form-item>
      <el-form-item style="margin: 10px 0; text-align: center">
        <el-button type="primary" size="small" autocomplete="off" @click="register">注册</el-button>
      </el-form-item>
      <el-form-item style="margin: 10px 0; text-align: center">
        <el-button type="warning" size="small" autocomplete="off" @click="$router.push('/login')">返回登录</el-button>
      </el-form-item>
    </el-form>
  </div>
</div>
</template>

<script>
export default {
  name:"Login",
  data() {
    return {
      user: {},
      rules: {
        username: [
          {required: true, message: '请输入用户名', trigger: 'blur'},
          {min: 3, max: 10, message: '长度在 3 到 10 个字符', trigger: 'blur'}
        ],
        password: [
          {required: true, message: '请输入密码', trigger: 'blur'},
          {min: 1, max: 20, message: '长度在 1 到 20 个字符', trigger: 'blur'}
        ],
        confirmPassword: [
          {required: true, message: '请确认密码', trigger: 'blur'},
          {min: 1, max: 20, message: '长度在 1 到 20 个字符', trigger: 'blur'}
        ],
        email: [
          {required: true, message: '请输入邮箱', trigger: 'blur'},
          {min: 10, max: 30, message: '长度在 10 到 30 个字符', trigger: 'blur'}
        ],
        phone: [
          {required: true, message: '请输入手机号', trigger: 'blur'},
          {min: 11, max: 11, message: '长度在11个字符', trigger: 'blur'}
        ],
      }
    }
  },
  methods: {
    register() {
      this.$refs["userForm"].validate((valid) => {
        if (valid) {
          if (this.user.password !== this.user.confirmPassword) {
            this.$message.error("两次输入的密码不一致！")
            return false
          }
          this.request.post("/user/register",this.user).then(res => {
            if (res.code === '200') {
              this.$message.success("注册成功！")
            } else {
              this.$message.error(res.msg)
            }
          })
        }
      });
    }
  }
}
</script>
<style>
  .wrapper {
    height: 100vh;
    background-image: linear-gradient(to bottom right, #FC466B, #3F5EFB);
    overflow: hidden;
  }
</style>

<style scoped>

</style>