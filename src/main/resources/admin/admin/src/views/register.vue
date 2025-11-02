<template>
	<div>
		<div class="register-container">
			<el-form v-if="pageFlag=='register'" ref="ruleForm" class="rgs-form animate__animated animate__fadeInDown" :model="ruleForm" :rules="rules">
				<div class="rgs-form2">
					<div class="title">基于SpringBoot与Vue.js的健康管理系统</div>
					<el-form-item class="list-item" v-if="tableName=='yonghu'">
						<div class="lable" :class="changeRules('yonghuzhanghao')?'required':''">用户账号：</div>
						<el-input  v-model="ruleForm.yonghuzhanghao"  autocomplete="off" placeholder="用户账号"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='yonghu'">
						<div class="lable" :class="changeRules('mima')?'required':''">密码：</div>
						<el-input  v-model="ruleForm.mima"  autocomplete="off" placeholder="密码"  type="password"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='yonghu'">
						<div class="lable" :class="changeRules('mima')?'required':''">确认密码：</div>
						<el-input  v-model="ruleForm.mima2" autocomplete="off" placeholder="确认密码" type="password" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='yonghu'">
						<div class="lable" :class="changeRules('yonghuxingming')?'required':''">用户姓名：</div>
						<el-input  v-model="ruleForm.yonghuxingming"  autocomplete="off" placeholder="用户姓名"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='yonghu'">
						<div class="lable" :class="changeRules('xingbie')?'required':''">性别：</div>
						<el-select v-model="ruleForm.xingbie" placeholder="请选择性别" >
							<el-option
								v-for="(item,index) in yonghuxingbieOptions"
								v-bind:key="index"
								:label="item"
								:value="item">
							</el-option>
						</el-select>
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='yonghu'">
						<div class="lable" :class="changeRules('nianling')?'required':''">年龄：</div>
						<el-input  v-model.number="ruleForm.nianling"  autocomplete="off" placeholder="年龄"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='yonghu'">
						<div class="lable" :class="changeRules('shouji')?'required':''">手机：</div>
						<el-input  v-model="ruleForm.shouji"  autocomplete="off" placeholder="手机"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='yonghu'">
						<div class="lable" :class="changeRules('touxiang')?'required':''">头像：</div>
						<file-upload
							tip="点击上传头像"
							action="file/upload"
							:limit="3"
							:multiple="true"
							:fileUrls="ruleForm.touxiang?ruleForm.touxiang:''"
							@change="yonghutouxiangUploadChange"
						></file-upload>
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='jiankangyisheng'">
						<div class="lable" :class="changeRules('yishenggonghao')?'required':''">医生工号：</div>
						<el-input  v-model="ruleForm.yishenggonghao"  autocomplete="off" placeholder="医生工号"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='jiankangyisheng'">
						<div class="lable" :class="changeRules('mima')?'required':''">密码：</div>
						<el-input  v-model="ruleForm.mima"  autocomplete="off" placeholder="密码"  type="password"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='jiankangyisheng'">
						<div class="lable" :class="changeRules('mima')?'required':''">确认密码：</div>
						<el-input  v-model="ruleForm.mima2" autocomplete="off" placeholder="确认密码" type="password" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='jiankangyisheng'">
						<div class="lable" :class="changeRules('yishengxingming')?'required':''">医生姓名：</div>
						<el-input  v-model="ruleForm.yishengxingming"  autocomplete="off" placeholder="医生姓名"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='jiankangyisheng'">
						<div class="lable" :class="changeRules('keshi')?'required':''">科室：</div>
						<el-input  v-model="ruleForm.keshi"  autocomplete="off" placeholder="科室"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='jiankangyisheng'">
						<div class="lable" :class="changeRules('zhicheng')?'required':''">职称：</div>
						<el-select v-model="ruleForm.zhicheng" placeholder="请选择职称" >
							<el-option
								v-for="(item,index) in jiankangyishengzhichengOptions"
								v-bind:key="index"
								:label="item"
								:value="item">
							</el-option>
						</el-select>
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='jiankangyisheng'">
						<div class="lable" :class="changeRules('lianxifangshi')?'required':''">联系方式：</div>
						<el-input  v-model="ruleForm.lianxifangshi"  autocomplete="off" placeholder="联系方式"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='jiankangyisheng'">
						<div class="lable" :class="changeRules('zhuanyeshanzhang')?'required':''">专业擅长：</div>
						<el-input  v-model="ruleForm.zhuanyeshanzhang"  autocomplete="off" placeholder="专业擅长"  type="text"  />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='jiankangyisheng'">
						<div class="lable" :class="changeRules('touxiang')?'required':''">头像：</div>
						<file-upload
							tip="点击上传头像"
							action="file/upload"
							:limit="3"
							:multiple="true"
							:fileUrls="ruleForm.touxiang?ruleForm.touxiang:''"
							@change="jiankangyishengtouxiangUploadChange"
						></file-upload>
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='jiankangyisheng'">
						<div class="lable" :class="changeRules('yishengjianjie')?'required':''">医生简介：</div>
						<editor
							myQuillEditor="yishengjianjie"
							style="min-width: 200px; max-width: 600px;"
							v-model="ruleForm.yishengjianjie" 
							class="editor" 
							action="file/upload">
						</editor>
					</el-form-item>
					<div class="register-btn">
						<div class="register-btn1">
							<button type="button" class="r-btn" @click="login()">注册</button>
						</div>
						<div class="register-btn2">
							<div class="r-login" @click="close()">已有账号，直接登录</div>
						</div>
					</div>
				</div>
			</el-form>
		</div>
	</div>
</template>

<script>
	import 'animate.css'
export default {
	data() {
		return {
			ruleForm: {
			},
			forgetForm: {},
            pageFlag : '',
			tableName:"",
			rules: {},
            yonghuxingbieOptions: [],
            jiankangyishengzhichengOptions: [],
		};
	},
	mounted(){
		this.pageFlag = this.$route.query.pageFlag
		if(this.$route.query.pageFlag=='register'){
			
			let table = this.$storage.get("loginTable");
			this.tableName = table;
			if(this.tableName=='yonghu'){
				this.ruleForm = {
					yonghuzhanghao: '',
					mima: '',
					yonghuxingming: '',
					xingbie: '',
					nianling: '',
					shouji: '',
					touxiang: '',
				}
			}
			if(this.tableName=='jiankangyisheng'){
				this.ruleForm = {
					yishenggonghao: '',
					mima: '',
					yishengxingming: '',
					keshi: '',
					zhicheng: '',
					lianxifangshi: '',
					zhuanyeshanzhang: '',
					yishengjianjie: '',
					touxiang: '',
				}
			}
			if ('yonghu' == this.tableName) {
				this.rules.yonghuzhanghao = [{ required: true, message: '请输入用户账号', trigger: 'blur' }]
			}
			if ('yonghu' == this.tableName) {
				this.rules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }]
			}
			if ('yonghu' == this.tableName) {
				this.rules.yonghuxingming = [{ required: true, message: '请输入用户姓名', trigger: 'blur' }]
			}
			if ('yonghu' == this.tableName) {
				this.rules.xingbie = [{ required: true, message: '请输入性别', trigger: 'blur' }]
			}
			if ('yonghu' == this.tableName) {
				this.rules.nianling = [{ required: true, message: '请输入年龄', trigger: 'blur' }]
			}
			if ('yonghu' == this.tableName) {
				this.rules.shouji = [{ required: true, message: '请输入手机', trigger: 'blur' }]
			}
			if ('jiankangyisheng' == this.tableName) {
				this.rules.yishenggonghao = [{ required: true, message: '请输入医生工号', trigger: 'blur' }]
			}
			if ('jiankangyisheng' == this.tableName) {
				this.rules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }]
			}
			if ('jiankangyisheng' == this.tableName) {
				this.rules.yishengxingming = [{ required: true, message: '请输入医生姓名', trigger: 'blur' }]
			}
			if ('jiankangyisheng' == this.tableName) {
				this.rules.keshi = [{ required: true, message: '请输入科室', trigger: 'blur' }]
			}
			if ('jiankangyisheng' == this.tableName) {
				this.rules.zhicheng = [{ required: true, message: '请输入职称', trigger: 'blur' }]
			}
			if ('jiankangyisheng' == this.tableName) {
				this.rules.lianxifangshi = [{ required: true, message: '请输入联系方式', trigger: 'blur' }]
			}
			if ('jiankangyisheng' == this.tableName) {
				this.rules.zhuanyeshanzhang = [{ required: true, message: '请输入专业擅长', trigger: 'blur' }]
			}
			this.yonghuxingbieOptions = "男,女".split(',')
			this.jiankangyishengzhichengOptions = "主任医师,副主任医师,主治医师".split(',')
		}
	},
	created() {
	},
	destroyed() {
		  	},
	methods: {
		changeRules(name){
			if(this.rules[name]){
				return true
			}
			return false
		},
		// 获取uuid
		getUUID () {
			return new Date().getTime();
		},
		close(){
			this.$router.push({ path: "/login" });
		},
        yonghutouxiangUploadChange(fileUrls) {
            this.ruleForm.touxiang = fileUrls;
        },
        jiankangyishengtouxiangUploadChange(fileUrls) {
            this.ruleForm.touxiang = fileUrls;
        },

        // 多级联动参数


		// 注册
		login() {
			var url=this.tableName+"/register";
			if((!this.ruleForm.yonghuzhanghao) && `yonghu` == this.tableName){
				this.$message.error(`用户账号不能为空`);
				return
			}
			if((!this.ruleForm.mima) && `yonghu` == this.tableName){
				this.$message.error(`密码不能为空`);
				return
			}
			if((this.ruleForm.mima!=this.ruleForm.mima2) && `yonghu` == this.tableName){
				this.$message.error(`两次密码输入不一致`);
				return
			}
			if((!this.ruleForm.yonghuxingming) && `yonghu` == this.tableName){
				this.$message.error(`用户姓名不能为空`);
				return
			}
			if((!this.ruleForm.xingbie) && `yonghu` == this.tableName){
				this.$message.error(`性别不能为空`);
				return
			}
			if((!this.ruleForm.nianling) && `yonghu` == this.tableName){
				this.$message.error(`年龄不能为空`);
				return
			}
			if(`yonghu` == this.tableName && this.ruleForm.nianling &&(!this.$validate.isIntNumer(this.ruleForm.nianling))){
				this.$message.error(`年龄应输入整数`);
				return
			}
			if((!this.ruleForm.shouji) && `yonghu` == this.tableName){
				this.$message.error(`手机不能为空`);
				return
			}
			if(`yonghu` == this.tableName && this.ruleForm.shouji &&(!this.$validate.isMobile(this.ruleForm.shouji))){
				this.$message.error(`手机应输入手机格式`);
				return
			}
            if(this.ruleForm.touxiang!=null) {
                this.ruleForm.touxiang = this.ruleForm.touxiang.replace(new RegExp(this.$base.url,"g"),"");
            }
			if((!this.ruleForm.yishenggonghao) && `jiankangyisheng` == this.tableName){
				this.$message.error(`医生工号不能为空`);
				return
			}
			if((!this.ruleForm.mima) && `jiankangyisheng` == this.tableName){
				this.$message.error(`密码不能为空`);
				return
			}
			if((this.ruleForm.mima!=this.ruleForm.mima2) && `jiankangyisheng` == this.tableName){
				this.$message.error(`两次密码输入不一致`);
				return
			}
			if((!this.ruleForm.yishengxingming) && `jiankangyisheng` == this.tableName){
				this.$message.error(`医生姓名不能为空`);
				return
			}
			if((!this.ruleForm.keshi) && `jiankangyisheng` == this.tableName){
				this.$message.error(`科室不能为空`);
				return
			}
			if((!this.ruleForm.zhicheng) && `jiankangyisheng` == this.tableName){
				this.$message.error(`职称不能为空`);
				return
			}
			if((!this.ruleForm.lianxifangshi) && `jiankangyisheng` == this.tableName){
				this.$message.error(`联系方式不能为空`);
				return
			}
			if(`jiankangyisheng` == this.tableName && this.ruleForm.lianxifangshi &&(!this.$validate.isMobile(this.ruleForm.lianxifangshi))){
				this.$message.error(`联系方式应输入手机格式`);
				return
			}
			if((!this.ruleForm.zhuanyeshanzhang) && `jiankangyisheng` == this.tableName){
				this.$message.error(`专业擅长不能为空`);
				return
			}
            if(this.ruleForm.touxiang!=null) {
                this.ruleForm.touxiang = this.ruleForm.touxiang.replace(new RegExp(this.$base.url,"g"),"");
            }
			this.$http({
				url: url,
				method: "post",
				data:this.ruleForm
			}).then(({ data }) => {
				if (data && data.code === 0) {
					this.$message({
						message: "注册成功",
						type: "success",
						duration: 1500,
						onClose: () => {
							this.$router.replace({ path: "/login" });
						}
					});
				} else {
					this.$message.error(data.msg);
				}
			});
		}
	}
};
</script>

<style lang="scss" scoped>
.register-container {
	position: relative;
	background: url(http://codegen.caihongy.cn/20240808/4690bab5e91648408e9ba44aedb3ccb2.jpg);
	background-repeat: no-repeat;
	background-size: cover;
	background: url(http://codegen.caihongy.cn/20240808/4690bab5e91648408e9ba44aedb3ccb2.jpg);
	display: flex;
	width: 100%;
	min-height: 100vh;
	justify-content: flex-end;
	align-items: center;
	background-position: center center;
	.rgs-form {
		.rgs-form2 {
		border-radius: 10px;
		padding: 30px 20px 20px;
		box-shadow: -10px 0px 13px -7px #000000, 10px 0px 13px -7px #000000, 5px 5px 15px 5px rgba(0,0,0,0);
		margin: 20px 20% 20px 0;
		background: #4dc57b;
		width: 550px;
		}
		border-radius: 0;
		padding: 0;
		margin: 0;
		background: none;
		display: flex;
		width: 100%;
		min-height: 100vh;
		justify-content: flex-end;
		align-items: center;
		position: relative;
		height: auto;
		.title {
			padding: 0 8% 0 15%;
			margin: 20px  20px 0;
			color: #000;
			top: 0;
			left: 0;
			background: none;
			font-weight: 600;
			width: calc(78% - 500px);
			font-size: 28px;
			line-height: 50px;
			position: absolute;
			text-align: left;
		}
		.list-item {
			padding: 0 0 0 0px;
			margin: 0 0 10px 120px;
			width: calc(90% - 130px);
			position: relative;
			height: auto;
			/deep/ .el-form-item__content {
				display: block;
			}
			.lable {
				padding: 0 10px 0 0;
				color: #fff;
				left: -130px;
				width: 130px;
				font-size: 16px;
				line-height: 34px;
				position: absolute !important;
				text-align: right;
			}
			.el-input {
				width: 100%;
			}
			.el-input /deep/ .el-input__inner {
				border: 1px solid rgba(255, 255, 255, .5);
				border-radius: 0px;
				padding: 0 10px;
				color: #fff;
				background: none;
				width: 100%;
				font-size: 14px;
				height: 34px;
			}
			.el-input /deep/ .el-input__inner:focus {
				border: 1px solid rgba(0, 0, 0, .5);
				border-radius: 0;
				padding: 0 10px;
				color: #fff;
				background: none;
				width: 100%;
				font-size: 16px;
				height: 34px;
			}
			.el-input-number {
				width: 100%;
			}
			.el-input-number /deep/ .el-input__inner {
				text-align: center;
				border: 1px solid rgba(255, 255, 255, .5);
				border-radius: 0px;
				padding: 0 10px;
				color: #fff;
				background: none;
				width: 100%;
				font-size: 14px;
				height: 34px;
			}
			.el-input-number /deep/ .el-input__inner:focus {
				border: 1px solid rgba(0, 0, 0, .5);
				border-radius: 0;
				padding: 0 10px;
				color: #fff;
				background: none;
				width: 100%;
				font-size: 16px;
				height: 34px;
			}
			.el-input-number /deep/ .el-input-number__decrease {
				display: none;
			}
			.el-input-number /deep/ .el-input-number__increase {
				display: none;
			}
			.el-select {
				width: 100%;
			}
			.el-select /deep/ .el-input__inner {
				border: 1px solid rgba(255, 255, 255, .5);
				border-radius: 0px;
				padding: 0 10px;
				color: #fff;
				background: none;
				width: 100%;
				font-size: 16px;
				height: 34px;
			}
			.el-select /deep/ .el-input__inner:focus {
				border: 1px solid rgba(0, 0, 0, .5);
				border-radius: 0;
				padding: 0 10px;
				color: #fff;
				background: none;
				width: 100%;
				font-size: 16px;
				height: 34px;
			}
			.el-date-editor {
				width: 100%;
			}
			.el-date-editor /deep/ .el-input__inner {
				border: 1px solid rgba(255, 255, 255, .5);
				border-radius: 0px;
				padding: 0 10px 0 30px;
				color: #fff;
				background: none;
				width: 100%;
				font-size: 16px;
				height: 34px;
			}
			.el-date-editor /deep/ .el-input__inner:focus {
				border: 1px solid rgba(0, 0, 0, .5);
				border-radius: 0;
				padding: 0 10px 0 30px;
				color: #fff;
				background: none;
				width: 100%;
				font-size: 16px;
				height: 34px;
			}
			.el-date-editor.el-input {
				width: 100%;
			}
			/deep/ .el-upload--picture-card {
				background: transparent;
				border: 0;
				border-radius: 0;
				width: auto;
				height: auto;
				line-height: initial;
				vertical-align: middle;
			}
			/deep/ .upload .upload-img {
				border: 1px solid rgba(255, 255, 255, .5);
				cursor: pointer;
				border-radius: 0px;
				color: #fff;
				background: none;
				width: 120px;
				font-size: 24px;
				line-height: 60px;
				text-align: center;
				height: 60px;
			}
			/deep/ .el-upload-list .el-upload-list__item {
				border: 1px solid rgba(255, 255, 255, .5);
				cursor: pointer;
				border-radius: 0px;
				color: #fff;
				background: none;
				width: 120px;
				font-size: 24px;
				line-height: 60px;
				text-align: center;
				height: 60px;
			}
			/deep/ .el-upload .el-icon-plus {
				border: 1px solid rgba(255, 255, 255, .5);
				cursor: pointer;
				border-radius: 0px;
				color: #fff;
				background: none;
				width: 120px;
				font-size: 24px;
				line-height: 60px;
				text-align: center;
				height: 60px;
			}
			/deep/ .el-upload__tip {
				color: #fff;
				font-size: 15px;
			}
			/deep/ .el-input__inner::placeholder {
				color: rgba(255, 255, 255, .6);
				font-size: 16px;
			}
			.required {
				position: relative;
			}
			.required::after{
				color: red;
				left: 110px;
				position: absolute;
				content: "*";
			}
			.editor {
				background: #fff;
				width: 100%;
				height: auto;
			}
			.editor>.avatar-uploader {
				line-height: 0;
				height: 0;
			}
		}
		.list-item.email {
			input {
				border: 1px solid rgba(255, 255, 255, .5);
				border-radius: 0px 0 0 0px;
				padding: 0 10px;
				margin: 0;
				color: #fff;
				background: none;
				flex: 1;
				width: 100%;
				font-size: 14px;
				height: 34px;
			}
			input:focus {
				border: 1px solid rgba(0, 0, 0, .5);
				border-radius: 0;
				padding: 0 10px;
				color: #fff;
				background: none;
				width: 100%;
				font-size: 14px;
				height: 34px;
			}
			input::placeholder {
				color: rgba(255, 255, 255, .6);
				font-size: 16px;
			}
			button {
				border: 0;
				cursor: pointer;
				border-radius: 0 0px 0px 0;
				padding: 0;
				margin: 3px 0 0;
				color: #333;
				background: #f5f5f5;
				width: 150px;
				font-size: 15px;
				height: 34px;
			}
			button:hover {
				opacity: 1;
			}
		}
		.register-btn {
			width: 100%;
		}
		.register-btn1 {
			width: 100%;
		}
		.register-btn2 {
			width: 100%;
		}
		.r-btn {
			border: 0px solid rgba(0, 0, 0, 1);
			cursor: pointer;
			border-radius: 4px;
			padding: 0 10px;
			margin: 20px auto 0 120px;
			color: rgba(0, 0, 0, 1);
			background: #fff;
			display: block;
			width: calc(90% - 130px);
			font-size: 16px;
			height: 40px;
		}
		.r-btn:hover {
			border: 0px solid rgba(85, 170, 0, 1.0);
			color: #00ad45;
			opacity: 0.8;
		}
		.r-login {
			cursor: pointer;
			padding: 0 0 0 120px;
			color: #fff;
			display: inline-block;
			text-decoration: underline;
			width: 80%;
			font-size: 16px;
			line-height: 50px;
			text-align: center;
		}
		.r-login:hover {
			color: #333;
			opacity: 0.8;
		}
	}
}
	
	::-webkit-scrollbar {
	  display: none;
	}
</style>
