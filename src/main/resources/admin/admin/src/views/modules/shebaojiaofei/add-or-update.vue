<template>
	<div class="addEdit-block">
		<el-form
			class="add-update-preview"
			ref="ruleForm"
			:model="ruleForm"
			:rules="rules"
			label-width="180px"
		>
			<template >
				<el-form-item class="select" v-if="type!='info'" label="用户账号" prop="yonghuzhanghao" >
					<el-select :disabled="ro.yonghuzhanghao" @change="yonghuzhanghaoChange" v-model="ruleForm.yonghuzhanghao" placeholder="请选择用户账号">
						<el-option
							v-for="(item,index) in yonghuzhanghaoOptions"
							v-bind:key="index"
							:label="item"
							:value="item">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item class="input" v-else-if="ruleForm.yonghuzhanghao" label="用户账号" prop="yonghuzhanghao" >
					<el-input v-model="ruleForm.yonghuzhanghao" placeholder="用户账号" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="用户姓名" prop="yonghuxingming" >
					<el-input v-model="ruleForm.yonghuxingming" placeholder="用户姓名" clearable  :readonly="ro.yonghuxingming"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="用户姓名" prop="yonghuxingming" >
					<el-input v-model="ruleForm.yonghuxingming" placeholder="用户姓名" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="社保类型" prop="shebaoleixing" >
					<el-input v-model="ruleForm.shebaoleixing" placeholder="社保类型" clearable  :readonly="ro.shebaoleixing"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="社保类型" prop="shebaoleixing" >
					<el-input v-model="ruleForm.shebaoleixing" placeholder="社保类型" readonly></el-input>
				</el-form-item>
				<el-form-item class="upload" v-if="type!='info' && !ro.shebaotupian" label="社保图片" prop="shebaotupian" >
					<file-upload
						tip="点击上传社保图片"
						action="file/upload"
						:limit="3"
						:multiple="true"
						:fileUrls="ruleForm.shebaotupian?ruleForm.shebaotupian:''"
						@change="shebaotupianUploadChange"
					></file-upload>
				</el-form-item>
				<el-form-item class="upload" v-else-if="ruleForm.shebaotupian" label="社保图片" prop="shebaotupian" >
					<img v-if="ruleForm.shebaotupian.substring(0,4)=='http'&&ruleForm.shebaotupian.split(',w').length>1" class="upload-img" style="margin-right:20px;" v-bind:key="index" :src="ruleForm.shebaotupian" width="100" height="100">
					<img v-else-if="ruleForm.shebaotupian.substring(0,4)=='http'" class="upload-img" style="margin-right:20px;" v-bind:key="index" :src="ruleForm.shebaotupian.split(',')[0]" width="100" height="100">
					<img v-else class="upload-img" style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in ruleForm.shebaotupian.split(',')" :src="$base.url+item" width="100" height="100">
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="社保价格" prop="shebaojiage" >
					<el-input-number v-model="ruleForm.shebaojiage" placeholder="社保价格" :disabled="ro.shebaojiage"></el-input-number>
				</el-form-item>
				<el-form-item v-else class="input" label="社保价格" prop="shebaojiage" >
					<el-input v-model="ruleForm.shebaojiage" placeholder="社保价格" readonly></el-input>
				</el-form-item>
				<el-form-item class="date" v-if="type!='info'" label="缴费日期" prop="jiaofeiriqi" >
					<el-date-picker
						format="yyyy 年 MM 月 dd 日"
						value-format="yyyy-MM-dd"
						v-model="ruleForm.jiaofeiriqi" 
						type="date"
						:readonly="ro.jiaofeiriqi"
						placeholder="缴费日期"
					></el-date-picker> 
				</el-form-item>
				<el-form-item class="input" v-else-if="ruleForm.jiaofeiriqi" label="缴费日期" prop="jiaofeiriqi" >
					<el-input v-model="ruleForm.jiaofeiriqi" placeholder="缴费日期" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="企业账号" prop="qiyezhanghao" >
					<el-input v-model="ruleForm.qiyezhanghao" placeholder="企业账号" clearable  :readonly="ro.qiyezhanghao"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="企业账号" prop="qiyezhanghao" >
					<el-input v-model="ruleForm.qiyezhanghao" placeholder="企业账号" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="负责人姓名" prop="fuzerenxingming" >
					<el-input v-model="ruleForm.fuzerenxingming" placeholder="负责人姓名" clearable  :readonly="ro.fuzerenxingming"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="负责人姓名" prop="fuzerenxingming" >
					<el-input v-model="ruleForm.fuzerenxingming" placeholder="负责人姓名" readonly></el-input>
				</el-form-item>
			</template>
			<el-form-item v-if="type!='info'"  label="缴费详情" prop="jiaofeixiangqing" >
				<editor 
					style="min-width: 200px; max-width: 600px;"
					v-model="ruleForm.jiaofeixiangqing" 
					class="editor" 
					action="file/upload">
				</editor>
			</el-form-item>
			<el-form-item v-else-if="ruleForm.jiaofeixiangqing" label="缴费详情" prop="jiaofeixiangqing" >
				<span class="text ql-snow ql-editor" v-html="ruleForm.jiaofeixiangqing"></span>
			</el-form-item>
			<el-form-item class="btn">
				<el-button class="btn3"  v-if="type!='info'" type="success" @click="onSubmit">
					<span class="icon iconfont icon-xihuan"></span>
					确认
				</el-button>
				<el-button class="btn4" v-if="type!='info'" type="success" @click="back()">
					<span class="icon iconfont icon-xihuan"></span>
					取消
				</el-button>
				<el-button class="btn5" v-if="type=='info'" type="success" @click="back()">
					<span class="icon iconfont icon-xihuan"></span>
					返回
				</el-button>
			</el-form-item>
		</el-form>
    

	</div>
</template>
<script>
	import { 
		isNumber,
	} from "@/utils/validate";
	export default {
		data() {
			var validateNumber = (rule, value, callback) => {
				if(!value){
					callback();
				} else if (!isNumber(value)) {
					callback(new Error("请输入数字"));
				} else {
					callback();
				}
			};
			return {
				id: '',
				type: '',
			
			
				ro:{
					yonghuzhanghao : false,
					yonghuxingming : false,
					shebaoleixing : false,
					shebaotupian : false,
					shebaojiage : false,
					jiaofeiriqi : false,
					jiaofeixiangqing : false,
					qiyezhanghao : false,
					fuzerenxingming : false,
					ispay : false,
				},
			
				ruleForm: {
					yonghuzhanghao: '',
					yonghuxingming: '',
					shebaoleixing: '',
					shebaotupian: '',
					shebaojiage: '',
					jiaofeiriqi: '',
					jiaofeixiangqing: '',
					qiyezhanghao: '',
					fuzerenxingming: '',
				},
				yonghuzhanghaoOptions: [],

				rules: {
					yonghuzhanghao: [
					],
					yonghuxingming: [
					],
					shebaoleixing: [
					],
					shebaotupian: [
					],
					shebaojiage: [
						{ validator: validateNumber, trigger: 'blur' },
					],
					jiaofeiriqi: [
					],
					jiaofeixiangqing: [
					],
					qiyezhanghao: [
					],
					fuzerenxingming: [
					],
					ispay: [
					],
				},
			};
		},
		props: ["parent"],
		computed: {



		},
		components: {
		},
		created() {
			this.ruleForm.jiaofeiriqi = this.getCurDate()
		},
		methods: {
			// 下载
			download(file){
				window.open(`${file}`)
			},
			// 初始化
			init(id,type) {
				if (id) {
					this.id = id;
					this.type = type;
				}
				if(this.type=='info'||this.type=='else'||this.type=='msg'){
					this.info(id);
				}else if(this.type=='logistics'){
					this.logistics=false;
					this.info(id);
				}else if(this.type=='cross'){
					var obj = this.$storage.getObj('crossObj');
					for (var o in obj){
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
						if(o=='shebaoleixing'){
							this.ruleForm.shebaoleixing = obj[o];
							this.ro.shebaoleixing = true;
							continue;
						}
						if(o=='shebaotupian'){
							this.ruleForm.shebaotupian = obj[o];
							this.ro.shebaotupian = true;
							continue;
						}
						if(o=='shebaojiage'){
							this.ruleForm.shebaojiage = obj[o];
							this.ro.shebaojiage = true;
							continue;
						}
						if(o=='jiaofeiriqi'){
							this.ruleForm.jiaofeiriqi = obj[o];
							this.ro.jiaofeiriqi = true;
							continue;
						}
						if(o=='jiaofeixiangqing'){
							this.ruleForm.jiaofeixiangqing = obj[o];
							this.ro.jiaofeixiangqing = true;
							continue;
						}
						if(o=='qiyezhanghao'){
							this.ruleForm.qiyezhanghao = obj[o];
							this.ro.qiyezhanghao = true;
							continue;
						}
						if(o=='fuzerenxingming'){
							this.ruleForm.fuzerenxingming = obj[o];
							this.ro.fuzerenxingming = true;
							continue;
						}
					}
				}
				// 获取用户信息
				this.$http({
					url: `${this.$storage.get('sessionTable')}/session`,
					method: "get"
				}).then(({ data }) => {
					if (data && data.code === 0) {
						var json = data.data;
						if(((json.qiyezhanghao!=''&&json.qiyezhanghao) || json.qiyezhanghao==0) && this.$storage.get("role")!="管理员"){
							this.ruleForm.qiyezhanghao = json.qiyezhanghao
							this.ro.qiyezhanghao = true;
						}
						if(((json.fuzerenxingming!=''&&json.fuzerenxingming) || json.fuzerenxingming==0) && this.$storage.get("role")!="管理员"){
							this.ruleForm.fuzerenxingming = json.fuzerenxingming
							this.ro.fuzerenxingming = true;
						}
					} else {
						this.$message.error(data.msg);
					}
				});
				this.$http({
					url: `option/yonghu/yonghuzhanghao`,
					method: "get"
				}).then(({ data }) => {
					if (data && data.code === 0) {
						this.yonghuzhanghaoOptions = data.data;
					} else {
						this.$message.error(data.msg);
					}
				});
			
			},
			// 下二随
			yonghuzhanghaoChange () {
				this.$http({
					url: `follow/yonghu/yonghuzhanghao?columnValue=`+ this.ruleForm.yonghuzhanghao,
					method: "get"
				}).then(({ data }) => {
					if (data && data.code === 0) {
						if(data.data.yonghuxingming){
							this.ruleForm.yonghuxingming = data.data.yonghuxingming
						}
					} else {
						this.$message.error(data.msg);
					}
				});
			},
			// 多级联动参数

			info(id) {
				this.$http({
					url: `shebaojiaofei/info/${id}`,
					method: "get"
				}).then(({ data }) => {
					if (data && data.code === 0) {
						this.ruleForm = data.data;
						//解决前台上传图片后台不显示的问题
						let reg=new RegExp('../../../upload','g')//g代表全部
						this.ruleForm.jiaofeixiangqing = this.ruleForm.jiaofeixiangqing.replace(reg,'../../../GZLS_IMS/upload');
					} else {
						this.$message.error(data.msg);
					}
				});
			},

			// 提交
			async onSubmit() {
					this.ruleForm.ispay = '未支付'
					if(this.ruleForm.shebaotupian!=null) {
						this.ruleForm.shebaotupian = this.ruleForm.shebaotupian.replace(new RegExp(this.$base.url,"g"),"");
					}
					var objcross = this.$storage.getObj('crossObj');
					await this.$refs["ruleForm"].validate(async valid => {
						if (valid) {
							if(this.type=='cross'){
								var statusColumnName = this.$storage.get('statusColumnName');
								var statusColumnValue = this.$storage.get('statusColumnValue');
								if(statusColumnName!='') {
									var obj = this.$storage.getObj('crossObj');
									if(statusColumnName && !statusColumnName.startsWith("[")) {
										for (var o in obj){
											if(o==statusColumnName){
												obj[o] = statusColumnValue;
											}
										}
										var table = this.$storage.get('crossTable');
										await this.$http({
											url: `${table}/update`,
											method: "post",
											data: obj
										}).then(({ data }) => {});
									}
								}
							}
							
							await this.$http({
								url: `shebaojiaofei/${!this.ruleForm.id ? "save" : "update"}`,
								method: "post",
								data: this.ruleForm
							}).then(async ({ data }) => {
								if (data && data.code === 0) {
									this.$message({
										message: "操作成功",
										type: "success",
										duration: 1500,
										onClose: () => {
											if(this.isAuth('shebaojiaofei','支付')&&this.type=='cross') {
												this.$confirm('是否跳转支付？').then(_ => {
													this.parent.showFlag = true;
													this.parent.addOrUpdateFlag = false;
													this.parent.shebaojiaofeiCrossAddOrUpdateFlag = false;
													this.$router.push('/shebaojiaofei')
												}).catch(_ => {
													this.parent.showFlag = true;
													this.parent.addOrUpdateFlag = false;
													this.parent.shebaojiaofeiCrossAddOrUpdateFlag = false;
													this.parent.search();
													this.parent.contentStyleChange();
												});
											}else {
												this.parent.showFlag = true;
												this.parent.addOrUpdateFlag = false;
												this.parent.shebaojiaofeiCrossAddOrUpdateFlag = false;
												this.parent.search();
												this.parent.contentStyleChange();
											}
											
										}
									});
								} else {
									this.$message.error(data.msg);
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
				this.parent.showFlag = true;
				this.parent.addOrUpdateFlag = false;
				this.parent.shebaojiaofeiCrossAddOrUpdateFlag = false;
				this.parent.contentStyleChange();
			},
			shebaotupianUploadChange(fileUrls) {
				this.ruleForm.shebaotupian = fileUrls;
			},
		}
	};
</script>
<style lang="scss" scoped>
	.addEdit-block {
		background-color: #F0F0F0;
		padding: 10px 30px;
		background: url(http://codegen.caihongy.cn/20241007/1527bf3dab4c4f3ca7113e3b3c21a87a.webp)  no-repeat right bottom;
	}
	.add-update-preview {
		padding: 0px;
		border-color: #eee;
		border-width: 0px 0 0;
		border-style: solid;
	}
	.amap-wrapper {
		width: 100%;
		height: 500px;
	}
	
	.search-box {
		position: absolute;
	}
	
	.el-date-editor.el-input {
		width: auto;
	}
	.add-update-preview /deep/ .el-form-item {
		border: 0px solid #eee;
		padding: 0;
		margin: 0 0 26px 0;
		display: inline-block;
		width: 100%;
	}
	.add-update-preview .el-form-item /deep/ .el-form-item__label {
		padding: 0 10px 0 0;
		color: #000;
		font-weight: 400;
		width: 180px;
		font-size: 14px;
		line-height: 40px;
		text-align: left;
	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__content {
		margin-left: 180px;
	}
	.add-update-preview .el-form-item span.text {
		padding: 0 10px;
		color: #333;
		background: none;
		font-weight: 500;
		display: inline-block;
		font-size: 16px;
		line-height: 40px;
		min-width: 50%;
	}
	
	.add-update-preview .el-input {
		width: 50%;
	}
	.add-update-preview .el-input /deep/ .el-input__inner {
		border: 1px solid #989898;
		border-radius: 5px;
		padding: 0 12px;
		color: #000;
		width: auto;
		font-size: 14px;
		min-width: 100%;
		height: 40px;
	}
	.add-update-preview .el-input /deep/ .el-input__inner[readonly="readonly"] {
		border: 0px solid #ccc;
		cursor: not-allowed;
		border-radius: 0px;
		padding: 0 12px;
		color: #B6B6B6;
		background: none;
		width: auto;
		font-size: 14px;
		height: 40px;
	}
	.add-update-preview .el-input-number {
		text-align: left;
		width: 50%;
	}
	.add-update-preview .el-input-number /deep/ .el-input__inner {
		text-align: left;
		border: 1px solid #989898;
		border-radius: 5px;
		padding: 0 12px;
		color: #000;
		width: auto;
		font-size: 14px;
		min-width: 100%;
		height: 40px;
	}
	.add-update-preview .el-input-number /deep/ .is-disabled .el-input__inner {
		text-align: left;
		border: 0px solid #ccc;
		cursor: not-allowed;
		border-radius: 0px;
		padding: 0 12px;
		color: #B6B6B6;
		background: none;
		width: auto;
		font-size: 14px;
		height: 40px;
	}
	.add-update-preview .el-input-number /deep/ .el-input-number__decrease {
		display: none;
	}
	.add-update-preview .el-input-number /deep/ .el-input-number__increase {
		display: none;
	}
	.add-update-preview .el-select {
		width: 50%;
	}
	.add-update-preview .el-select /deep/ .el-input__inner {
		border: 1px solid #989898;
		border-radius: 5px;
		padding: 0 10px;
		color: #000;
		width: 100%;
		font-size: 14px;
		height: 40px;
	}
	.add-update-preview .el-select /deep/ .is-disabled .el-input__inner {
		border: 0;
		cursor: not-allowed;
		border-radius: 4px;
		padding: 0 10px;
		color: #B6B6B6;
		background: none;
		width: auto;
		font-size: 14px;
		height: 34px;
	}
	.add-update-preview .el-date-editor {
		width: 50%;
	}
	.add-update-preview .el-date-editor /deep/ .el-input__inner {
		border: 1px solid #989898;
		border-radius: 5px;
		padding: 0 10px 0 30px;
		color: #000;
		background: #fff;
		width: 50%;
		font-size: 14px;
		height: 40px;
	}
	.add-update-preview .el-date-editor /deep/ .el-input__inner[readonly="readonly"] {
		border: 0;
		cursor: not-allowed;
		border-radius: 0px;
		padding: 0 10px 0 30px;
		color: #B6B6B6;
		background: none;
		width: auto;
		font-size: 14px;
		height: 40px;
	}
	.add-update-preview .viewBtn {
		border: 0px solid #ccc;
		cursor: pointer;
		border-radius: 0px;
		padding: 0 15px;
		margin: 0 20px 0 0;
		color: #666;
		background: #fff;
		width: auto;
		font-size: 15px;
		line-height: 34px;
		height: 34px;
		.iconfont {
			margin: 0 2px;
			color: #666;
			font-size: 16px;
			height: 34px;
		}
	}
	.add-update-preview .viewBtn:hover {
		opacity: 0.8;
	}
	.add-update-preview .downBtn {
		border: 0px solid #ccc;
		cursor: pointer;
		border-radius: 0px;
		padding: 0 15px;
		margin: 0 20px 0 0;
		color: #666;
		background: #fff;
		width: auto;
		font-size: 15px;
		line-height: 34px;
		height: 34px;
		.iconfont {
			margin: 0 2px;
			color: #666;
			font-size: 16px;
			height: 34px;
		}
	}
	.add-update-preview .downBtn:hover {
		opacity: 0.8;
	}
	.add-update-preview .unBtn {
		border: 0;
		cursor: not-allowed;
		border-radius: 4px;
		padding: 0 0px;
		margin: 0 20px 0 0;
		outline: none;
		color: #999;
		background: none;
		width: auto;
		font-size: 16px;
		line-height: 40px;
		height: 40px;
		.iconfont {
			margin: 0 2px;
			color: #fff;
			display: none;
			font-size: 14px;
			height: 34px;
		}
	}
	.add-update-preview .unBtn:hover {
		opacity: 0.8;
	}
	.add-update-preview /deep/ .el-upload--picture-card {
		background: transparent;
		border: 0;
		border-radius: 0;
		width: auto;
		height: auto;
		line-height: initial;
		vertical-align: middle;
	}
	
	.add-update-preview /deep/ .upload .upload-img {
		border: 1px solid #989898;
		cursor: pointer;
		border-radius: 5px;
		color: #666;
		background: #fff;
		width: 90px;
		font-size: 24px;
		line-height: 60px;
		text-align: center;
		height: 60px;
	}
	
	.add-update-preview /deep/ .el-upload-list .el-upload-list__item {
		border: 1px solid #989898;
		cursor: pointer;
		border-radius: 5px;
		color: #666;
		background: #fff;
		width: 90px;
		font-size: 24px;
		line-height: 60px;
		text-align: center;
		height: 60px;
	}
	
	.add-update-preview /deep/ .el-upload .el-icon-plus {
		border: 1px solid #989898;
		cursor: pointer;
		border-radius: 5px;
		color: #666;
		background: #fff;
		width: 90px;
		font-size: 24px;
		line-height: 60px;
		text-align: center;
		height: 60px;
	}
	.add-update-preview /deep/ .el-upload__tip {
		color: #666;
		font-size: 15px;
	}
	
	.add-update-preview .el-textarea /deep/ .el-textarea__inner {
		border: 1px solid #989898;
		border-radius: 5px;
		padding: 12px;
		color: #666;
		background: #fff;
		width: 80%;
		font-size: 14px;
		min-width: 400px;
		height: 120px;
	}
	.add-update-preview .el-textarea /deep/ .el-textarea__inner[readonly="readonly"] {
				border: 0;
				cursor: not-allowed;
				border-radius: 0px;
				padding: 12px;
				color: #B6B6B6;
				background: none;
				width: auto;
				font-size: 14px;
				min-width: 400px;
				height: auto;
			}
	.add-update-preview .el-form-item.btn {
		padding: 0;
		margin: 20px 0 0;
		.btn1 {
			border: 0px solid #ccc;
			cursor: pointer;
			border-radius: 4px;
			padding: 0 10px;
			margin: 0 10px 0 0;
			color: #fff;
			background: #5EC0CD;
			width: auto;
			font-size: 16px;
			min-width: 110px;
			height: 40px;
			.iconfont {
				margin: 0 2px;
				color: #fff;
				display: none;
				font-size: 14px;
				height: 40px;
			}
		}
		.btn1:hover {
			opacity: 0.8;
		}
		.btn2 {
			border: 0px solid #ccc;
			cursor: pointer;
			border-radius: 4px;
			padding: 0 10px;
			margin: 0 10px 0 0;
			color: #fff;
			background: #FFBA59;
			width: auto;
			font-size: 16px;
			min-width: 110px;
			height: 40px;
			.iconfont {
				margin: 0 2px;
				color: #fff;
				display: none;
				font-size: 14px;
				height: 34px;
			}
		}
		.btn2:hover {
			opacity: 0.8;
		}
		.btn3 {
			border: 0px solid #ccc;
			cursor: pointer;
			border-radius: 4px;
			padding: 0 10px;
			margin: 0 10px 0 0;
			color: #fff;
			background: #92A465;
			width: auto;
			font-size: 16px;
			min-width: 110px;
			height: 40px;
			.iconfont {
				margin: 0 2px;
				color: #fff;
				display: none;
				font-size: 14px;
				height: 40px;
			}
		}
		.btn3:hover {
			opacity: 0.8;
		}
		.btn4 {
			border: 0px solid #ccc;
			cursor: pointer;
			border-radius: 4px;
			padding: 0 10px;
			margin: 0 10px 0 0;
			color: #fff;
			background: #707EFF;
			width: auto;
			font-size: 16px;
			min-width: 110px;
			height: 40px;
			.iconfont {
				margin: 0 2px;
				color: #fff;
				display: none;
				font-size: 14px;
				height: 40px;
			}
		}
		.btn4:hover {
			opacity: 0.8;
		}
		.btn5 {
			border: 0px solid #ccc;
			cursor: pointer;
			border-radius: 4px;
			padding: 0 10px;
			margin: 0 10px 0 0;
			color: #fff;
			background: #5EC0CD;
			width: auto;
			font-size: 16px;
			min-width: 110px;
			height: 40px;
			.iconfont {
				margin: 0 2px;
				color: #fff;
				display: none;
				font-size: 14px;
				height: 40px;
			}
		}
		.btn5:hover {
			opacity: 0.8;
		}
	}
</style>
