<template>
	<div>

		<div class="container">
			<el-form class='rgs-form animate__animated animate__fadeInDown' v-if="pageFlag=='register'" ref="registerForm" :model="registerForm" :rules="rules">
				<div class="rgs-form2">
					<div class="title">基于SpringBoot的广州市劳动与社会保障信息管理系统的设计与实现</p></div>
					<el-form-item class="list-item" v-if="tableName=='yonghu'" prop="yonghuzhanghao">
						<div class="label" :class="changeRules('yonghuzhanghao')?'required':''">用户账号：</div>
						<el-input v-model="registerForm.yonghuzhanghao"  placeholder="请输入用户账号" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='yonghu'" prop="mima">
						<div class="label" :class="changeRules('mima')?'required':''">密码：</div>
						<el-input v-model="registerForm.mima" type="password" placeholder="请输入密码" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='yonghu'" prop="mima2">
						<div class="label" :class="changeRules('mima')?'required':''">确认密码：</div>
						<el-input v-model="registerForm.mima2" type="password" placeholder="请再次输入密码" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='yonghu'" prop="yonghuxingming">
						<div class="label" :class="changeRules('yonghuxingming')?'required':''">用户姓名：</div>
						<el-input v-model="registerForm.yonghuxingming"  placeholder="请输入用户姓名" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='yonghu'" prop="xingbie">
						<div class="label" :class="changeRules('xingbie')?'required':''">性别：</div>
						<el-select v-model="registerForm.xingbie" placeholder="请选择性别" >
							<el-option
								v-for="(item,index) in yonghuxingbieOptions"
								:key="index"
								:label="item"
								:value="item">
							</el-option>
						</el-select>
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='yonghu'" prop="touxiang">
						<div class="label" :class="changeRules('touxiang')?'required':''">头像：</div>
						<file-upload
							tip="点击上传头像"
							action="file/upload"
							:limit="1"
							:multiple="true"
							:fileUrls="registerForm.touxiang?registerForm.touxiang:''"
							@change="yonghutouxiangUploadChange"
						></file-upload>
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='yonghu'" prop="lianxifangshi">
						<div class="label" :class="changeRules('lianxifangshi')?'required':''">联系方式：</div>
						<el-input v-model="registerForm.lianxifangshi"  placeholder="请输入联系方式" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='yonghu'" prop="nianling">
						<div class="label" :class="changeRules('nianling')?'required':''">年龄：</div>
						<el-input v-model.number="registerForm.nianling"  placeholder="请输入年龄" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='qiye'" prop="qiyezhanghao">
						<div class="label" :class="changeRules('qiyezhanghao')?'required':''">企业账号：</div>
						<el-input v-model="registerForm.qiyezhanghao"  placeholder="请输入企业账号" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='qiye'" prop="mima">
						<div class="label" :class="changeRules('mima')?'required':''">密码：</div>
						<el-input v-model="registerForm.mima" type="password" placeholder="请输入密码" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='qiye'" prop="mima2">
						<div class="label" :class="changeRules('mima')?'required':''">确认密码：</div>
						<el-input v-model="registerForm.mima2" type="password" placeholder="请再次输入密码" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='qiye'" prop="fuzerenxingming">
						<div class="label" :class="changeRules('fuzerenxingming')?'required':''">负责人姓名：</div>
						<el-input v-model="registerForm.fuzerenxingming"  placeholder="请输入负责人姓名" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='qiye'" prop="xingbie">
						<div class="label" :class="changeRules('xingbie')?'required':''">性别：</div>
						<el-select v-model="registerForm.xingbie" placeholder="请选择性别" >
							<el-option
								v-for="(item,index) in qiyexingbieOptions"
								:key="index"
								:label="item"
								:value="item">
							</el-option>
						</el-select>
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='qiye'" prop="touxiang">
						<div class="label" :class="changeRules('touxiang')?'required':''">头像：</div>
						<file-upload
							tip="点击上传头像"
							action="file/upload"
							:limit="1"
							:multiple="true"
							:fileUrls="registerForm.touxiang?registerForm.touxiang:''"
							@change="qiyetouxiangUploadChange"
						></file-upload>
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='qiye'" prop="lianxifangshi">
						<div class="label" :class="changeRules('lianxifangshi')?'required':''">联系方式：</div>
						<el-input v-model="registerForm.lianxifangshi"  placeholder="请输入联系方式" />
					</el-form-item>
					<el-form-item class="list-item" v-if="tableName=='qiye'" prop="qiyezizhi">
						<div class="label" :class="changeRules('qiyezizhi')?'required':''">企业资质：</div>
						<file-upload
							tip="点击上传企业资质"
							action="file/upload"
							:limit="1"
							:multiple="true"
							:fileUrls="registerForm.qiyezizhi?registerForm.qiyezizhi:''"
							@change="qiyeqiyezizhiUploadChange"
						></file-upload>
					</el-form-item>
					<div class="register-btn">
						<div class="register-btn1">
							<el-button class="register_btn" type="primary" @click="submitForm('registerForm')">注册</el-button>
						</div>
						<div class="register-btn2">
							<router-link class="has_btn" to="/login">已有账号，直接登录</router-link>
						</div>
					</div>
				</div>
				<div class="idea1"></div>
				<div class="idea2"></div>
			</el-form>
		</div>
	</div>
</div>
</template>

<script>
	import 'animate.css';

export default {
    //数据集合
    data() {
		return {
            pageFlag : '',
			tableName: '',
			registerForm: {},
			forgetForm: {},
			rules: {},
			requiredRules: {},
            yonghuxingbieOptions: [],
            qiyexingbieOptions: [],
		}
    },
	mounted() {
		if(this.$route.query.pageFlag=='register'){
			this.tableName = this.$route.query.role;
			if(this.tableName=='yonghu'){
				this.registerForm = {
					yonghuzhanghao: '',
					mima: '',
					mima2: '',
					yonghuxingming: '',
					xingbie: '',
					touxiang: '',
					lianxifangshi: '',
					nianling: '',
				}
			}
			if(this.tableName=='qiye'){
				this.registerForm = {
					qiyezhanghao: '',
					mima: '',
					mima2: '',
					fuzerenxingming: '',
					xingbie: '',
					touxiang: '',
					lianxifangshi: '',
					qiyezizhi: '',
					sfsh: '',
					shhf: '',
				}
			}
			if ('yonghu' == this.tableName) {
				this.rules.yonghuzhanghao = [{ required: true, message: '请输入用户账号', trigger: 'blur' }];
				this.requiredRules.yonghuzhanghao = [{ required: true, message: '请输入用户账号', trigger: 'blur' }]
			}
			if ('yonghu' == this.tableName) {
				this.rules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }];
				this.requiredRules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }]
			}
			if ('yonghu' == this.tableName) {
				this.rules.yonghuxingming = [{ required: true, message: '请输入用户姓名', trigger: 'blur' }];
				this.requiredRules.yonghuxingming = [{ required: true, message: '请输入用户姓名', trigger: 'blur' }]
			}
			this.yonghuxingbieOptions = "男,女".split(',');
			if ('yonghu' == this.tableName) {
				this.rules.lianxifangshi = [{ required: true, validator: this.$validate.isMobile, trigger: 'blur' }];
			}
			if ('yonghu' == this.tableName) {
				this.rules.nianling = [{ required: true, validator: this.$validate.isIntNumer, trigger: 'blur' }];
			}
			if ('qiye' == this.tableName) {
				this.rules.qiyezhanghao = [{ required: true, message: '请输入企业账号', trigger: 'blur' }];
				this.requiredRules.qiyezhanghao = [{ required: true, message: '请输入企业账号', trigger: 'blur' }]
			}
			if ('qiye' == this.tableName) {
				this.rules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }];
				this.requiredRules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }]
			}
			if ('qiye' == this.tableName) {
				this.rules.fuzerenxingming = [{ required: true, message: '请输入负责人姓名', trigger: 'blur' }];
				this.requiredRules.fuzerenxingming = [{ required: true, message: '请输入负责人姓名', trigger: 'blur' }]
			}
			this.qiyexingbieOptions = "男,女".split(',');
			if ('qiye' == this.tableName) {
				this.rules.lianxifangshi = [{ required: true, validator: this.$validate.isMobile, trigger: 'blur' }];
			}
		}
	},
    created() {
		this.pageFlag = this.$route.query.pageFlag;
    },
    //方法集合
    methods: {
		changeRules(name){
			if(this.requiredRules[name]){
				return true
			}
			return false
		},
		// 获取uuid
		getUUID () {
			return new Date().getTime();
		},
        // 下二随
		yonghutouxiangUploadChange(fileUrls) {
			this.registerForm.touxiang = fileUrls.replace(new RegExp(this.$config.baseUrl,"g"),"");
		},
		qiyetouxiangUploadChange(fileUrls) {
			this.registerForm.touxiang = fileUrls.replace(new RegExp(this.$config.baseUrl,"g"),"");
		},
		qiyeqiyezizhiUploadChange(fileUrls) {
			this.registerForm.qiyezizhi = fileUrls.replace(new RegExp(this.$config.baseUrl,"g"),"");
		},

		// 多级联动参数


		submitForm(formName) {
			this.$refs[formName].validate((valid) => {
				if (valid) {
					var url=this.tableName+"/register";
					if(`yonghu` == this.tableName && this.registerForm.mima!=this.registerForm.mima2) {
						this.$message.error(`两次密码输入不一致`);
						return
					}
					if(this.tableName=='qiye'){
						this.registerForm.sfsh = '待审核'
					}
					if(`qiye` == this.tableName && this.registerForm.mima!=this.registerForm.mima2) {
						this.$message.error(`两次密码输入不一致`);
						return
					}
					this.$http.post(url, this.registerForm).then(res => {
						if (res.data.code === 0) {
							this.$message({
								message: '注册成功',
								type: 'success',
								duration: 1500,
								onClose: () => {
									this.$router.push('/login');
								}
							});
						} else {
							this.$message.error(res.data.msg);
						}
					});
				} else {
					return false;
				}
			});
		},
		resetForm(formName) {
			this.$refs[formName].resetFields();
		}
    }
}
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.container {
		background-repeat: no-repeat;
		background: url(http://codegen.caihongy.cn/20241104/f36a96ebedfc4cbb9a6cfb7e1443ebb5.webp);
		display: flex;
		width: 100%;
		min-height: 100vh;
		justify-content: center;
		align-items: center;
		background-position: center center;
		position: relative;
		background: url(http://codegen.caihongy.cn/20241104/f36a96ebedfc4cbb9a6cfb7e1443ebb5.webp);
		.rgs-form {
			scrollbar-width: thin;
			padding: 0;
			margin: 0;
			overflow: auto;
			background: #fff;
			width: auto;
			overflow-x: hidden;
			height: calc(100vh - 100px);
			.rgs-form2 {
				padding: 0 89px;
				margin: 0;
				background: #FFF;
				width: 600px;
				.title {
					margin: 30px 0 20px -40px;
					color: #000;
					font-weight: 700;
					width: calc(100% + 80px);
					font-size: 18px;
					line-height: auto;
					text-align: center;
				}
				.subtitle {
					margin: 0 0 10px 0;
					text-shadow: 4px 4px 2px rgba(64, 158, 255, .5);
					color: rgba(64, 158, 255, 1);
					width: 100%;
					font-size: 20px;
					line-height: 44px;
					text-align: center;
				}
				.list-item {
					border: 1px solid #CACACA;
					border-radius: 30px;
					box-shadow: inset 0px 4px 10px 0px rgba(0,0,0,0.3);
					margin: 0 0 30px 0;
					background: none;
					display: flex;
					width: 100%;
					align-items: center;
					flex-wrap: wrap;
					/deep/.el-form-item__content {
						padding: 0 0 0 120px;
						display: block;
						width: calc(100% - 0px);
						.label {
							padding: 0 5px 0 0;
							z-index: 9;
							color: #333;
							left: 0;
							width: 120px;
							font-size: 16px;
							line-height: 60px;
							position: absolute !important;
							text-align: right;
						}
						
						.required {
							position: relative;
						}
						.required::after{
							margin: 0 10px 0 0;
							color: red;
							left: 110px;
							position: inherit;
							content: "*";
						}
						.el-input {
							flex: 1;
							width: 100%;
						}
						.el-input .el-input__inner {
							border: 0px solid #ddd;
							padding: 0 10px;
							color: #000000;
							background: none;
							width: 100%;
							font-size: 15px;
							height: 60px;
						}
						.el-input .el-input__inner:focus {
							border: 0px solid #ddd;
							padding: 0 10px;
							color: #000000;
							flex: 1;
							background: none;
							width: 100%;
							font-size: 15px;
							height: 60px;
						}
						.el-input-number {
							flex: 1;
							width: 100%;
						}
						.el-input-number /deep/ .el-input__inner {
							text-align: left;
							border: 0px solid #ddd;
							padding: 0 10px;
							color: #000000;
							background: none;
							width: 100%;
							font-size: 15px;
							height: 60px;
						}
						.el-input-number /deep/ .el-input-number__decrease {
							display: none;
						}
						.el-input-number /deep/ .el-input-number__increase {
							display: none;
						}
						.el-select {
							flex: 1;
							width: 100%;
						}
						.el-select .el-input__inner {
							border: 0px solid #ddd;
							padding: 0 10px;
							color: #000000;
							flex: 1;
							background: none;
							width: 100%;
							font-size: 15px;
							height: 60px;
						}
						.el-select .el-input__inner:focus {
							border: 0px solid #ddd;
							padding: 0 10px;
							color: #000000;
							flex: 1;
							background: none;
							width: 100%;
							font-size: 15px;
							height: 60px;
						}
						.el-date-editor {
							flex: 1;
							width: 100%;
						}
						.el-date-editor .el-input__inner {
							border: 0px solid #ddd;
							padding: 0 10px 0 40px;
							color: #000000;
							flex: 1;
							background: none;
							width: 100%;
							font-size: 15px;
							height: 60px;
						}
						.el-date-editor .el-input__inner:focus {
							border: 0px solid #ddd;
							padding: 0 10px 0 40px;
							color: #000000;
							flex: 1;
							background: none;
							width: 100%;
							font-size: 15px;
							height: 60px;
						}
						.el-upload--picture-card {
							background: transparent;
							border: 0;
							border-radius: 0;
							width: auto;
							height: auto;
							line-height: initial;
							vertical-align: middle;
						}
						.upload .upload-img {
							border: 1px solid #ddd;
							cursor: pointer;
							border-radius: 0px;
							margin: 10px 0 0;
							color: #999;
							background: #fff;
							object-fit: cover;
							width: 80px;
							font-size: 24px;
							line-height: 60px;
							text-align: center;
							height: 60px;
						}
						.el-upload-list .el-upload-list__item {
							border: 1px solid #ddd;
							cursor: pointer;
							border-radius: 0px;
							margin: 10px 0 0;
							color: #999;
							background: #fff;
							object-fit: cover;
							width: 80px;
							font-size: 24px;
							line-height: 60px;
							text-align: center;
							height: 60px;
							font-size: 14px;
							line-height: 1.8;
						}
						.el-upload .el-icon-plus {
							border: 1px solid #ddd;
							cursor: pointer;
							border-radius: 0px;
							margin: 10px 0 0;
							color: #999;
							background: #fff;
							object-fit: cover;
							width: 80px;
							font-size: 24px;
							line-height: 60px;
							text-align: center;
							height: 60px;
						}
						.el-upload__tip {
							margin: 0;
							color: #666;
							font-size: 15px;
						}
						.emailInput {
							border: 0px solid #ddd;
							padding: 0 10px;
							outline: none;
							color: #000000;
							flex: 1;
							background: none;
							width: 100%;
							font-size: 15px;
							height: 60px;
						}
						.emailInput:focus {
							border: 0px solid #ddd;
							padding: 0 10px;
							color: #000000;
							flex: 1;
							background: none;
							width: 100%;
							font-size: 15px;
							height: 60px;
						}
						.el-btn {
							border: none;
							cursor: pointer;
							border-radius: 0 30px 30px 0;
							padding: 0 10px;
							margin: 0;
							color: #fff;
							background: #5DB5B7;
							width: 110px;
							font-size: 15px;
							border-width: 1px 1px 1px 0;
							float: right;
							height: 60px;
						}
						.el-btn:hover {
							background: #2d7173;
						}
						
						.el-input__inner::placeholder {
							color: #e9e9e9;
							font-size: 15px;
						}
						input::placeholder {
							color: #e9e9e9;
							font-size: 15px;
						}
						.editor {
							border-radius: 30px;
							padding: 20px;
							margin: 0 0 0 0px;
							background: none;
							width: calc(100% - 0px);
							height: auto;
						}
					}
				}
				.register-btn {
					margin: 0;
					flex-direction: column;
					display: flex;
					width: 100%;
				}
				.register-btn1 {
					padding: 20px 0 30px 0;
					width: 100%;
					order: 2;
				}
				.register-btn2 {
					padding: 0;
					margin: 0;
					width: 100%;
					text-align: center;
				}
				.register_btn {
					border: 0;
					cursor: pointer;
					border-radius: 30px;
					padding: 0 30px;
					margin: 0 0px;
					color: #fff;
					background: #5DB5B7;
					width: 100%;
					font-size: 24px;
					height: 60px;
				}
				.register_btn:hover {
					background: #2d7173;
				}
				.has_btn {
					cursor: pointer;
					padding: 0;
					color: #555;
					display: inline-block;
					text-decoration: none;
					font-size: 15px;
					line-height: 30px;
				}
				.has_btn:hover {
					color: #5db5b7;
				}
			}
			.idea1 {
				background: red;
				display: none;
				width: 100%;
				height: 40px;
			}
			.idea2 {
				background: blue;
				display: none;
				width: 100%;
				height: 40px;
			}
		}
	}
	
	::-webkit-scrollbar {
		display: none;
	}
</style>
