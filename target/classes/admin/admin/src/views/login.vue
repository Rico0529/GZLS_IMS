<template>
	<div>
		<div class="login-container">
			<el-form class="login_form animate__animated animate__backInDown">
				<div class="login_form2">
					<div class="title-container">基于SpringBoot的广州市劳动与社会保障信息管理系统的设计与实现</div>
					<div v-if="loginType==1" class="list-item">
						<div class="lable">
							账号
						</div>
						<input placeholder="请输入账号" name="username" type="text" v-model="rulesForm.username">
					</div>
					<div v-if="loginType==1" class="list-item">
						<div class="lable">
							密码
						</div>
						<div class="password-box">
							<input placeholder="请输入密码" name="password" :type="showPassword?'text':'password'" v-model="rulesForm.password">
							<span class="icon iconfont" :class="showPassword?'icon-liulan13':'icon-liulan17'" @click="showPassword=!showPassword"></span>
						</div>
					</div>

					<div class="list-item select" v-if="roles.length>1">
						<div class="lable">
							角色
						</div>
						<el-select v-model="rulesForm.role" placeholder="请选择角色">
							<el-option v-if="loginType==1||(loginType==2&&item.roleName!='管理员')" v-for="item in roles" :key="item.roleName" :label="item.roleName" :value="item.roleName" />
						</el-select>
					</div>

		
					<div class="login-btn">
						<div class="login-btn1">
							<el-button v-if="loginType==1" type="primary" @click="login()" class="loginInBt">登录</el-button>
						</div>
						<div class="login-btn2">
							<el-button type="primary" @click="register('qiye')" class="register">
								注册企业							</el-button>
						</div>
						<div class="login-btn3">
						</div>
					</div>
				</div>
			</el-form>
		</div>
	</div>
</template>
<script>
	import 'animate.css'
	import menu from "@/utils/menu";
	export default {
		data() {
			return {
				verifyCheck2: false,
				flag: false,
				baseUrl:this.$base.url,
				loginType: 1,
				rulesForm: {
					username: "",
					password: "",
					role: "",
				},
				menus: [],
				roles: [],
				tableName: "",
				showPassword: false,
			};
		},
		mounted() {
			let menus = menu.list();
			this.menus = menus;

			for (let i = 0; i < this.menus.length; i++) {
				if (this.menus[i].hasBackLogin=='是') {
					this.roles.push(this.menus[i])
				}
			}

		},
		created() {

		},
		destroyed() {
		},
		components: {
		},
		methods: {

			//注册
			register(tableName){
				this.$storage.set("loginTable", tableName);
				this.$router.push({path:'/register',query:{pageFlag:'register'}})
			},
			// 登陆
			login() {

				if (!this.rulesForm.username) {
					this.$message.error("请输入用户名");
					return;
				}
				if (!this.rulesForm.password) {
					this.$message.error("请输入密码");
					return;
				}
				if(this.roles.length>1) {
					if (!this.rulesForm.role) {
						this.$message.error("请选择角色");
						return;
					}

					let menus = this.menus;
					for (let i = 0; i < menus.length; i++) {
						if (menus[i].roleName == this.rulesForm.role) {
							this.tableName = menus[i].tableName;
						}
					}
				} else {
					this.tableName = this.roles[0].tableName;
					this.rulesForm.role = this.roles[0].roleName;
				}
		
				this.loginPost()
			},
			loginPost() {
				this.$http({
					url: `${this.tableName}/login?username=${this.rulesForm.username}&password=${this.rulesForm.password}`,
					method: "post"
				}).then(({ data }) => {
					if (data && data.code === 0) {
						this.$storage.set("Token", data.token);
						this.$storage.set("role", this.rulesForm.role);
						this.$storage.set("sessionTable", this.tableName);
						this.$storage.set("adminName", this.rulesForm.username);
						this.$router.replace({ path: "/" });
					} else {
						this.$message.error(data.msg);
					}
				});
			},
		}
	}
</script>

<style lang="scss" scoped>
.login-container {
	min-height: 100vh;
	position: relative;
	background-repeat: no-repeat;
	background-position: center center;
	background-size: cover;
	background: url(http://codegen.caihongy.cn/20240925/4b8262eef5784fd584baaba5b929a80a.webp);
	background-repeat: no-repeat;
	background-size: cover;
	background: url(http://codegen.caihongy.cn/20240925/4b8262eef5784fd584baaba5b929a80a.webp);
	display: flex;
	width: 100%;
	min-height: 100vh;
	justify-content: center;
	align-items: center;
	background-position: center center;

	.login_form {
		padding: 0 0 0 44px;
		margin: 10px auto;
		z-index: 1000;
		display: flex;
		flex-wrap: wrap;
		border-radius: 0;
		box-shadow: none;
		flex-direction: column;
		background: url(http://codegen.caihongy.cn/20240925/d80b0ba5237c4ae48d1ae206fda80fb0.webp);
		width: 630px;
		align-items: flex-start;
		position: relative;
		height: 875px;
		.login_form2 {
			width: 100%;
		}
		.title-container {
			padding: 0;
			margin: 120px 0 0 0;
			color: #000;
			background: none;
			font-weight: 600;
			width: 280px;
			font-size: 28px;
			min-height: 90px;
			text-align: left;
			height: auto;
		}
		.list-item {
			padding: 0;
			margin: 0 0 10px;
			display: flex;
			width: 430px;
			align-items: center;
			position: relative;
			flex-wrap: wrap;
			.lable {
				padding: 0 0 0 10px;
				color: #333333;
				width: 100%;
				font-size: 14px;
				line-height: 40px;
				text-align: left;
			}
			input {
				border: 1px solid #ABABAB;
				border-radius: 5px;
				padding: 0 10px;
				outline: none;
				color: #000;
				width: 430px;
				font-size: 14px;
				height: 60px;
			}
			input:focus {
				border: 1px solid #1890ff;
				border-radius: 5px;
				padding: 0 10px;
				color: #000;
				width: 430px;
				font-size: 14px;
				height: 60px;
			}
			.password-box {
				display: flex;
				width: 100%;
				position: relative;
				align-items: center;
				input {
					border: 1px solid #ABABAB;
					border-radius: 5px;
					padding: 0 10px;
					color: #000;
					width: 430px;
					font-size: 14px;
					height: 60px;
				}
				input:focus {
					border: 1px solid #1890ff;
					border-radius: 5px;
					padding: 0 10px;
					color: #000;
					width: 430px;
					font-size: 14px;
					height: 60px;
				}
				.iconfont {
					cursor: pointer;
					z-index: 1;
					color: #000;
					top: 0;
					font-size: 16px;
					line-height: 60px;
					position: absolute;
					right: 8px;
				}
			}
			input::placeholder {
				color: #9E9E9E;
				font-size: 14px;
			}
			/deep/ .el-select {
				width: 100%;
			}
			/deep/ .el-select .el-input__inner {
				border: 1px solid #ABABAB;
				padding: 0 10px;
				color: rgba(64, 158, 255, 1);
				width: 430px;
				font-size: 14px;
				height: 60px;
				order: 2;
			}
			/deep/ .el-select .is-focus .el-input__inner {
				border: 1px solid rgba(85, 170, 0, 1.0);
				padding: 0 10px;
				color: rgba(85, 170, 0, 1.0);
				width: 430px;
				font-size: 14px;
				height: 60px;
				order: 1;
			}
			/deep/ .el-select .el-input__inner::placeholder{
				color: #9E9E9E;
				font-size: 14px;
			}
		}
		.login-btn {
			margin: 40px 0 0 0;
			display: flex;
			width: auto;
			justify-content: flex-start;
			align-items: center;
			flex-wrap: wrap;
			.login-btn1 {
				width: 100%;
				order: 4;
			}
			.login-btn2 {
				display: flex;
				width: 100%;
				justify-content: flex-start;
				align-items: center;
				flex-wrap: wrap;
			}
			.login-btn3 {
				display: flex;
				width: 430px;
				justify-content: flex-end;
				align-items: center;
				order: 2;
			}
			.loginInBt {
				border: 0px solid rgba(0, 0, 0, 1);
				cursor: pointer;
				border-radius: 5px;
				padding: 0 10px;
				box-shadow: 0px 4px 10px 0px rgba(0,0,0,0.3);
				margin: 40px 0 0 0;
				color: #fff;
				background: #5EC0CD;
				font-weight: 700;
				width: 190px;
				font-size: 24px;
				height: 64px;
			}
			.loginInBt:hover {
				opacity: 0.8;
			}
			.register {
				border: none;
				cursor: pointer;
				border-radius: 0;
				padding: 0 10px;
				margin: 0;
				color: #000000;
				background: #fff;
				display: inline;
				width: auto;
				font-size: 14px;
				height: auto;
			}
			.register:hover {
				opacity: 0.8;
			}
			.forget {
				border: 0;
				cursor: pointer;
				border-radius: 0;
				padding: 0;
				margin: 0 10px 0 0;
				color: #000;
				background: none;
				width: auto;
				font-size: 14px;
				text-align: left;
				height: auto;
			}
			.forget:hover {
				color: #0d6efd;
				opacity: 1;
			}
		}
	}
}

</style>
