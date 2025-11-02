<template>
	<div class="add-update-preview">
		<el-form
			class="add-update-form"
			ref="ruleForm"
			:model="ruleForm"
			:rules="rules"
			label-width="180px"
			>
			<el-form-item class="add-item" label="日期" prop="riqi">
				<el-date-picker
					:disabled=" false  ||ro.riqi"
					format="yyyy 年 MM 月 dd 日"
					value-format="yyyy-MM-dd"
					v-model="ruleForm.riqi" 
					type="date"
					placeholder="日期">
				</el-date-picker> 
			</el-form-item>
			<el-form-item class="add-item" label="身高(m)" prop="shengao">
				<el-input-number v-model="ruleForm.shengao" placeholder="身高(m)" :disabled=" false ||ro.shengao"></el-input-number>
			</el-form-item>
			<el-form-item class="add-item" label="体重(kg)" prop="tizhong">
				<el-input-number v-model="ruleForm.tizhong" placeholder="体重(kg)" :disabled=" false ||ro.tizhong"></el-input-number>
			</el-form-item>
			<el-form-item class="add-item" label="血压(mmHg)" prop="xueya">
				<el-input-number v-model="ruleForm.xueya" placeholder="血压(mmHg)" :disabled=" false ||ro.xueya"></el-input-number>
			</el-form-item>
			<el-form-item class="add-item" label="血糖(mmol/L)" prop="xuetang">
				<el-input-number v-model="ruleForm.xuetang" placeholder="血糖(mmol/L)" :disabled=" false ||ro.xuetang"></el-input-number>
			</el-form-item>
			<el-form-item class="add-item" label="心率(次)" prop="xinlv">
				<el-input v-model.number="ruleForm.xinlv" 
					placeholder="心率(次)" clearable :disabled=" false  ||ro.xinlv"></el-input>
			</el-form-item>
			<el-form-item class="add-item" label="BMI" prop="shentizhiliang">
				<el-input v-model="shentizhiliang" placeholder="BMI" disabled></el-input>
			</el-form-item>
			<el-form-item class="add-item" label="体检报告" prop="tijianbaogao">
				<file-upload
					tip="点击上传体检报告"
					action="file/upload"
					:limit="1"
					:type="3"
					:multiple="true"
					:fileUrls="ruleForm.tijianbaogao?ruleForm.tijianbaogao:''"
					@change="tijianbaogaoUploadChange"
					></file-upload>
			</el-form-item>  
			<el-form-item class="add-item" label="用户账号" prop="yonghuzhanghao">
				<el-input v-model="ruleForm.yonghuzhanghao" 
					placeholder="用户账号" clearable :disabled=" false  ||ro.yonghuzhanghao"></el-input>
			</el-form-item>
			<el-form-item class="add-item" label="用户姓名" prop="yonghuxingming">
				<el-input v-model="ruleForm.yonghuxingming" 
					placeholder="用户姓名" clearable :disabled=" false  ||ro.yonghuxingming"></el-input>
			</el-form-item>
			<el-form-item class="add-item" label="性别" prop="xingbie">
				<el-input v-model="ruleForm.xingbie" 
					placeholder="性别" clearable :disabled=" false  ||ro.xingbie"></el-input>
			</el-form-item>
			<el-form-item class="add-item" label="年龄" prop="nianling">
				<el-input v-model.number="ruleForm.nianling" 
					placeholder="年龄" clearable :disabled=" false  ||ro.nianling"></el-input>
			</el-form-item>
			<el-form-item class="add-item" label="头像" v-if="type!='cross' || (type=='cross' && !ro.touxiang)" prop="touxiang">
				<file-upload
					tip="点击上传头像"
					action="file/upload"
					:limit="3"
					:multiple="true"
					:fileUrls="ruleForm.touxiang?ruleForm.touxiang:''"
					@change="touxiangUploadChange"
					></file-upload>
			</el-form-item>
			<el-form-item class="add-item" v-else label="头像" prop="touxiang">
				<img v-if="ruleForm.touxiang.substring(0,4)=='http'" class="upload-img" v-bind:key="index" :src="ruleForm.touxiang.split(',')[0]">
				<img v-else class="upload-img" v-bind:key="index" v-for="(item,index) in ruleForm.touxiang.split(',')" :src="baseUrl+item">
			</el-form-item>
			<el-form-item class="add-item" label="运动记录" prop="yundongjilu">
				<el-input
					type="textarea"
					:rows="8"
					placeholder="运动记录"
					v-model="ruleForm.yundongjilu">
					</el-input>
			</el-form-item>

			<el-form-item class="add-btn-item">
				<el-button class="submitBtn"  type="primary" @click="onSubmit">
					<span class="icon iconfont "></span>
					<span class="text">提交</span>
				</el-button>
				<el-button class="closeBtn" @click="back()">
					<span class="icon iconfont "></span>
					<span class="text">取消</span>
				</el-button>
			</el-form-item>
		</el-form>
	</div>
</template>

<script>
	export default {
		data() {
			return {
				id: '',
				baseUrl: '',
				ro:{
					riqi : false,
					shengao : false,
					tizhong : false,
					xueya : false,
					xuetang : false,
					xinlv : false,
					shentizhiliang : false,
					yundongjilu : false,
					tijianbaogao : false,
					yonghuzhanghao : false,
					yonghuxingming : false,
					xingbie : false,
					nianling : false,
					touxiang : false,
				},
				type: '',
				userTableName: localStorage.getItem('UserTableName'),
				ruleForm: {
					riqi: '',
					shengao: '',
					tizhong: '',
					xueya: '',
					xuetang: '',
					xinlv: '',
					shentizhiliang: '',
					yundongjilu: '',
					tijianbaogao: '',
					yonghuzhanghao: '',
					yonghuxingming: '',
					xingbie: '',
					nianling: '',
					touxiang: '',
				},


				rules: {
					riqi: [
					],
					shengao: [
						{ validator: this.$validate.isNumber, trigger: 'blur' },
					],
					tizhong: [
						{ validator: this.$validate.isNumber, trigger: 'blur' },
					],
					xueya: [
						{ validator: this.$validate.isNumber, trigger: 'blur' },
					],
					xuetang: [
						{ validator: this.$validate.isNumber, trigger: 'blur' },
					],
					xinlv: [
						{ validator: this.$validate.isIntNumer, trigger: 'blur' },
					],
					shentizhiliang: [
						{ validator: this.$validate.isNumber, trigger: 'blur' },
					],
					yundongjilu: [
					],
					tijianbaogao: [
					],
					yonghuzhanghao: [
					],
					yonghuxingming: [
					],
					xingbie: [
					],
					nianling: [
						{ validator: this.$validate.isIntNumer, trigger: 'blur' },
					],
					touxiang: [
					],
				},
				centerType: false,
			};
		},
		computed: {
			shentizhiliang : {
				get: function () {
					let c = this.ruleForm
					let a = c.tizhong/(c.shengao*c.shengao)
					this.ruleForm.shentizhiliang = a?Number(Number(a).toFixed(2)):0
					return a?Number(Number(a).toFixed(2)):0
				}
				
			},



		},
		components: {
		},
		created() {
			if(this.$route.query.centerType){
				this.centerType = true
			}
			//this.bg();
			let type = this.$route.query.type ? this.$route.query.type : '';
			this.init(type);
			this.baseUrl = this.$config.baseUrl;
			this.ruleForm.riqi = this.getCurDate()
		},
		methods: {
			getMakeZero(s) {
				return s < 10 ? '0' + s : s;
			},
			// 下载
			download(file){
				window.open(`${file}`)
			},
			// 初始化
			init(type) {
				this.type = type;
				if(type=='cross'){
					var obj = JSON.parse(localStorage.getItem('crossObj'));
					for (var o in obj){
						if(o=='riqi'){
							this.ruleForm.riqi = obj[o];
							this.ro.riqi = true;
							continue;
						}
						if(o=='shengao'){
							this.ruleForm.shengao = obj[o];
							this.ro.shengao = true;
							continue;
						}
						if(o=='tizhong'){
							this.ruleForm.tizhong = obj[o];
							this.ro.tizhong = true;
							continue;
						}
						if(o=='xueya'){
							this.ruleForm.xueya = obj[o];
							this.ro.xueya = true;
							continue;
						}
						if(o=='xuetang'){
							this.ruleForm.xuetang = obj[o];
							this.ro.xuetang = true;
							continue;
						}
						if(o=='xinlv'){
							this.ruleForm.xinlv = obj[o];
							this.ro.xinlv = true;
							continue;
						}
						if(o=='shentizhiliang'){
							this.ruleForm.shentizhiliang = obj[o];
							this.ro.shentizhiliang = true;
							continue;
						}
						if(o=='yundongjilu'){
							this.ruleForm.yundongjilu = obj[o];
							this.ro.yundongjilu = true;
							continue;
						}
						if(o=='tijianbaogao'){
							this.ruleForm.tijianbaogao = obj[o];
							this.ro.tijianbaogao = true;
							continue;
						}
						if(o=='yonghuzhanghao'){
							this.ruleForm.yonghuzhanghao = obj[o];
							this.ro.yonghuzhanghao = true;
							continue;
						}
						if(o=='yonghuxingming'){
							this.ruleForm.yonghuxingming = obj[o];
							this.ro.yonghuxingming = true;
							continue;
						}
						if(o=='xingbie'){
							this.ruleForm.xingbie = obj[o];
							this.ro.xingbie = true;
							continue;
						}
						if(o=='nianling'){
							this.ruleForm.nianling = obj[o];
							this.ro.nianling = true;
							continue;
						}
						if(o=='touxiang'){
							this.ruleForm.touxiang = obj[o]?obj[o].split(",")[0]:'';
							this.ro.touxiang = true;
							continue;
						}
					}
				}else if(type=='edit'){
					this.info()
				}
				// 获取用户信息
				this.$http.get(this.userTableName + '/session', {emulateJSON: true}).then(res => {
					if (res.data.code == 0) {
						var json = res.data.data;
						if((json.yonghuzhanghao!=''&&json.yonghuzhanghao) || json.yonghuzhanghao==0){
							this.ruleForm.yonghuzhanghao = json.yonghuzhanghao;
							this.ro.yonghuzhanghao = true;
						}
						if((json.yonghuxingming!=''&&json.yonghuxingming) || json.yonghuxingming==0){
							this.ruleForm.yonghuxingming = json.yonghuxingming;
							this.ro.yonghuxingming = true;
						}
						if((json.xingbie!=''&&json.xingbie) || json.xingbie==0){
							this.ruleForm.xingbie = json.xingbie;
							this.ro.xingbie = true;
						}
						if((json.nianling!=''&&json.nianling) || json.nianling==0){
							this.ruleForm.nianling = json.nianling;
							this.ro.nianling = true;
						}
						if((json.touxiang!=''&&json.touxiang) || json.touxiang==0){
							this.ruleForm.touxiang = json.touxiang;
							this.ro.touxiang = true;
						}
					}
				});

				if (localStorage.getItem('raffleType') && localStorage.getItem('raffleType') != null) {
					localStorage.removeItem('raffleType')
					setTimeout(() => {
						this.onSubmit()
					}, 300)
				}
			},

			// 多级联动参数
			// 多级联动参数
			info() {
				this.$http.get(`jiankangshuju/detail/${this.$route.query.id}`, {emulateJSON: true}).then(res => {
					if (res.data.code == 0) {
						this.ruleForm = res.data.data;
					}
				});
			},
			// 提交
			async onSubmit() {
				if(this.ruleForm.shentizhiliang==0){
					this.$message.error('BMI不能为空')
					return false
				}
				if(!this.ruleForm.id) {
					delete this.ruleForm.userid
				}
				await this.$refs["ruleForm"].validate(async valid => {
					if(valid) {
						if(this.type=='cross'){
							var statusColumnName = localStorage.getItem('statusColumnName');
							var statusColumnValue = localStorage.getItem('statusColumnValue');
							if(statusColumnName && statusColumnName!='') {
								var obj = JSON.parse(localStorage.getItem('crossObj'));
								if(!statusColumnName.startsWith("[")) {
									for (var o in obj){
										if(o==statusColumnName){
											obj[o] = statusColumnValue;
										}
									}
									var table = localStorage.getItem('crossTable');
									await this.$http.post(table+'/update', obj).then(res => {});
								}
							}
						}


						await this.$http.post(`jiankangshuju/${this.ruleForm.id?'update':this.centerType?'save':'add'}`, this.ruleForm).then(async res => {
							if (res.data.code == 0) {
								this.$message({
									message: '操作成功',
									type: 'success',
									duration: 1500,
									onClose: () => {
										this.$router.go(-1);
										
									}
								});
							} else {
								this.$message({
									message: res.data.msg,
									type: 'error',
									duration: 1500
								});
							}
						});
					}
				});
			},
			// 获取uuid
			getUUID () {
				return new Date().getTime();
			},
			// 返回
			back() {
				this.$router.go(-1);
			},
			tijianbaogaoUploadChange(fileUrls) {
				this.ruleForm.tijianbaogao = fileUrls.replace(new RegExp(this.$config.baseUrl,"g"),"");
			},
			touxiangUploadChange(fileUrls) {
				this.ruleForm.touxiang = fileUrls.replace(new RegExp(this.$config.baseUrl,"g"),"");
			},
		}
	};
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.add-update-preview {
		padding: 0 0 20px;
		margin: 0px auto;
		color: #666;
		background: #fff;
		width: 1200px;
		font-size: 16px;
		position: relative;
		.add-update-form {
			padding: 20px 15% 20px 5%;
			margin: 20px 0 0;
			width: 100%;
			position: relative;
			.add-item.el-form-item {
				border-radius: 0px;
				padding: 6px 0 0;
				margin: 0 0 20px 0;
				background: none;
				border-color: #475a8310;
				border-width:  0 0 0px;
				border-style: solid;
				/deep/ .el-form-item__label {
					padding: 0 10px 0 0;
					color: #666;
					font-weight: 500;
					width: 180px;
					font-size: inherit;
					line-height: 40px;
					text-align: right;
				}
				/deep/ .el-form-item__content {
					margin-left: 180px;
				}
				.el-input {
					width: 100%;
				}
				.el-input /deep/ .el-input__inner {
					border: 1px solid #ddd;
					border-radius: 30px;
					padding: 0 12px;
					box-shadow: none;
					color: inherit;
					width: 100%;
					font-size: 16px;
					height: 40px;
				}
				.el-input /deep/ .el-input__inner[readonly="readonly"] {
					border: 0;
					cursor: not-allowed;
					border-radius: 0px;
					padding: 0 12px;
					box-shadow: none;
					color: rgba(85, 85, 127, 1.0);
					background: none;
					width: 100%;
					font-size: 16px;
					height: 40px;
				}
				.el-input-number /deep/ .el-input__inner {
					text-align: left;
					border: 1px solid #ddd;
					border-radius: 30px;
					padding: 0 12px;
					box-shadow: none;
					color: inherit;
					width: 100%;
					font-size: 16px;
					height: 40px;
				}
				.el-input-number /deep/ .is-disabled .el-input__inner {
					text-align: left;
					border: 0;
					cursor: not-allowed;
					border-radius: 0px;
					padding: 0 12px;
					box-shadow: none;
					color: rgba(85, 85, 127, 1.0);
					background: none;
					width: 100%;
					font-size: 16px;
					height: 40px;
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
					border: 1px solid #ddd;
					border-radius: 30px;
					padding: 0 10px;
					color: inherit;
					width: 100%;
					font-size: 16px;
					min-width: inherit !important;
					height: 40px;
				}
				.el-select /deep/ .is-disabled .el-input__inner {
					border: 0;
					cursor: not-allowed;
					border-radius: 0px;
					padding: 0 10px;
					box-shadow: none;
					color: inherit;
					background: none;
					width: 100%;
					font-size: 16px;
					height: 40px;
				}
				.el-date-editor {
					width: 100%;
				}
				.el-date-editor /deep/ .el-input__inner {
					border: 1px solid #ddd;
					border-radius: 30px;
					padding: 0 10px 0 30px;
					box-shadow: none;
					color: inherit;
					width: 100%;
					font-size: 16px;
					height: 40px;
				}
				.el-date-editor /deep/ .el-input__inner[readonly="readonly"] {
					border: 0;
					cursor: not-allowed;
					border-radius: 0px;
					padding: 0 10px 0 30px;
					box-shadow: none;
					color: inherit;
					background: none;
					width: 100%;
					font-size: 16px;
					height: 40px;
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
					border: 1px solid #ddd;
					cursor: pointer;
					border-radius: 30px;
					color: #999;
					background: #fff;
					width: 120px;
					font-size: 26px;
					line-height: 60px;
					text-align: center;
					height: 60px;
				}
				/deep/ .el-upload-list .el-upload-list__item {
					border: 1px solid #ddd;
					cursor: pointer;
					border-radius: 30px;
					color: #999;
					background: #fff;
					width: 120px;
					font-size: 26px;
					line-height: 60px;
					text-align: center;
					height: 60px;
					font-size: 14px;
					line-height: 1.8;
				}
				/deep/ .el-upload .el-icon-plus {
					border: 1px solid #ddd;
					cursor: pointer;
					border-radius: 30px;
					color: #999;
					background: #fff;
					width: 120px;
					font-size: 26px;
					line-height: 60px;
					text-align: center;
					height: 60px;
				}
				/deep/ .el-upload__tip {
					color: #888;
					font-size: 16px;
				}
				.el-textarea /deep/ .el-textarea__inner {
					border: 1px solid #ddd;
					border-radius: 30px;
					padding: 12px;
					box-shadow: none;
					color: inherit;
					width: 100%;
					font-size: 16px;
					min-height: 150px;
					min-width: 48%;
					height: auto;
				}
				.el-textarea /deep/ .el-textarea__inner[readonly="readonly"] {
					border: 0px solid #ddd;
					cursor: not-allowed;
					border-radius: 30px;
					padding: 12px;
					box-shadow: none;
					color: inherit;
					background: none;
					width: 100%;
					font-size: 16px;
					min-height: 150px;
					min-width: 50%;
					height: auto;
				}
				/deep/ .el-input__inner::placeholder {
					color: inherit;
					font-size: inherit;
				}
				/deep/ textarea::placeholder {
					color: inherit;
					font-size: inherit;
				}
				.editor {
					background-color: #fff;
					border-radius: 0px;
					padding: 0px;
					box-shadow: none;
					margin: 0;
					width: 100%;
					min-height: 350px;
					border-color: #ccc;
					border-width: 1px;
					border-style: solid;
					height: auto;
				}
				.upload-img {
					border-radius: 10px;
					object-fit: cover;
					width: 100px;
					height: 100px;
				}
				.viewBtn {
					border: 0;
					cursor: pointer;
					border-radius: 4px;
					padding: 0 20px;
					margin: 0;
					color: #333;
					background: #475a8330;
					display: inline-block;
					width: auto;
					font-size: 14px;
					line-height: 34px;
					height: 34px;
				}
				.viewBtn:hover {
				}
				.unviewBtn {
					border: 0;
					cursor: pointer;
					padding: 0 20px;
					margin: 0;
					color: #333;
					display: inline-block;
					font-size: 14px;
					line-height: 34px;
					border-radius: 4px;
					outline: none;
					background: #ddd;
					width: auto;
					height: 34px;
				}
				.unviewBtn:hover {
				}
			}
			.add-btn-item {
				padding: 0;
				margin: 20px 0;
				.submitBtn {
					border: 0;
					cursor: pointer;
					padding: 0 24px 0 30px;
					margin: 0 20px 0 0;
					display: inline-block;
					font-size: 16px;
					line-height: 44px;
					border-radius: 4px;
					background: #0066D4;
					width: auto;
					text-align: center;
					min-width: 120px;
					height: 44px;
					.icon {
						color: #fff;
					}
					.text {
						color: #fff;
					}
				}
				.submitBtn:hover {
					color: #fff;
					.icon {
					}
					.text {
					}
				}
				.closeBtn {
					border: 1px solid #0066D450;
					cursor: pointer;
					padding: 0 24px 0 30px;
					margin: 0 20px 0 0;
					color: #0066D4;
					display: inline-block;
					font-size: 16px;
					line-height: 44px;
					border-radius: 4px;
					background: #fff;
					width: auto;
					text-align: center;
					min-width: 120px;
					height: 44px;
					.icon {
						color: #333;
					}
					.text {
						color: #0066D4;
					}
				}
				.closeBtn:hover {
					color: #80593c;
					.icon {
					}
					.text {
					}
				}
			}
		}
	}
	.el-date-editor.el-input {
		width: auto;
	}
</style>
