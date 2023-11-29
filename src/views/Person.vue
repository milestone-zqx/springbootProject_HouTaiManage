<template>
<div>
  <el-card style="width: 1000px; text-align: center">
  <el-form label-width="80px" >
    <el-form-item label="用户名">
      <el-input v-model="form.username" autocomplete="off"></el-input>
    </el-form-item>
    <el-form-item label="昵称">
      <el-input v-model="form.nickname" autocomplete="off"></el-input>
    </el-form-item>
    <el-form-item label="邮箱">
      <el-input v-model="form.email" autocomplete="off"></el-input>
    </el-form-item>
    <el-form-item label="电话">
      <el-input v-model="form.phone" autocomplete="off"></el-input>
    </el-form-item>
    <el-form-item label="地址">
      <el-input v-model="form.address" autocomplete="off"></el-input>
    </el-form-item>
    <el-form-item style="margin: 20px 0; text-align: center">
      <el-button type="primary" @click="save">确 定</el-button>
    </el-form-item>
  </el-form>
  </el-card>
</div>
</template>

<script>
export default {
  name: "Person",
  data() {
    return {
      form:{},
      user: localStorage.getItem("user") ? JSON.parse(localStorage.getItem("user")) : {}
    }
  },
  created() {
    this.request.get("/user/username/"+this.user.username).then(res => {
      if (res.code === '200') {
        this.form = res.data
      }
    })
  },
  methods: {
    save(){
      this.request.post("/user/save",this.form).then(res => {
        if(res) {
          this.$message.success("保存成功！")
        } else {
          this.$message.error("保存失败！")
        }
      })
    },
  }
}
</script>

<style scoped>

</style>