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
				<el-form-item class="input" v-if="type!='info'"  label="补贴名称" prop="butiemingcheng" >
					<el-input v-model="ruleForm.butiemingcheng" placeholder="补贴名称" clearable  :readonly="ro.butiemingcheng"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="补贴名称" prop="butiemingcheng" >
					<el-input v-model="ruleForm.butiemingcheng" placeholder="补贴名称" readonly></el-input>
				</el-form-item>
				<el-form-item class="upload" v-if="type!='info' && !ro.butiefengmian" label="补贴封面" prop="butiefengmian" >
					<file-upload
						tip="点击上传补贴封面"
						action="file/upload"
						:limit="3"
						:multiple="true"
						:fileUrls="ruleForm.butiefengmian?ruleForm.butiefengmian:''"
						@change="butiefengmianUploadChange"
					></file-upload>
				</el-form-item>
				<el-form-item class="upload" v-else-if="ruleForm.butiefengmian" label="补贴封面" prop="butiefengmian" >
					<img v-if="ruleForm.butiefengmian.substring(0,4)=='http'&&ruleForm.butiefengmian.split(',w').length>1" class="upload-img" style="margin-right:20px;" v-bind:key="index" :src="ruleForm.butiefengmian" width="100" height="100">
					<img v-else-if="ruleForm.butiefengmian.substring(0,4)=='http'" class="upload-img" style="margin-right:20px;" v-bind:key="index" :src="ruleForm.butiefengmian.split(',')[0]" width="100" height="100">
					<img v-else class="upload-img" style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in ruleForm.butiefengmian.split(',')" :src="$base.url+item" width="100" height="100">
				</el-form-item>
				<el-form-item class="upload" v-if="type!='info'&& !ro.butieziliao" label="补贴资料" prop="butieziliao" >
					<file-upload
						tip="点击上传补贴资料"
						action="file/upload"
						:limit="1"
						:type="3"
						:multiple="true"
						:fileUrls="ruleForm.butieziliao?ruleForm.butieziliao:''"
						@change="butieziliaoUploadChange"
					></file-upload>
				</el-form-item>  
				<el-form-item v-else-if="ruleForm.butieziliao" label="补贴资料" prop="butieziliao" >
					<el-button class="downBtn" type="text" size="small" @click="download($base.url+ruleForm.butieziliao)">
						<span class="icon iconfont icon-xiazai6"></span>
						下载
					</el-button>
				</el-form-item>
				<el-form-item v-else-if="!ruleForm.butieziliao" label="补贴资料" prop="butieziliao" >
					<el-button class="unBtn" type="text" size="small">
						<span class="icon iconfont icon-xihuan"></span>
						暂无
					</el-button>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="补贴金额" prop="butiejine" >
					<el-input-number v-model="ruleForm.butiejine" placeholder="补贴金额" :disabled="ro.butiejine"></el-input-number>
				</el-form-item>
				<el-form-item v-else class="input" label="补贴金额" prop="butiejine" >
					<el-input v-model="ruleForm.butiejine" placeholder="补贴金额" readonly></el-input>
				</el-form-item>
				<el-form-item class="select" v-if="type!='info'"  label="申请状态" prop="shenqingzhuangtai" >
					<el-select :disabled="ro.shenqingzhuangtai" v-model="ruleForm.shenqingzhuangtai" placeholder="请选择申请状态" >
						<el-option
							v-for="(item,index) in shenqingzhuangtaiOptions"
							v-bind:key="index"
							:label="item"
							:value="item">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item v-else class="input" label="申请状态" prop="shenqingzhuangtai" >
					<el-input v-model="ruleForm.shenqingzhuangtai"
						placeholder="申请状态" readonly></el-input>
				</el-form-item>
				<el-form-item class="date" v-if="type!='info'" label="申请时间" prop="shenqingshijian" >
					<el-date-picker
						format="yyyy 年 MM 月 dd 日"
						value-format="yyyy-MM-dd"
						v-model="ruleForm.shenqingshijian" 
						type="date"
						:readonly="ro.shenqingshijian"
						placeholder="申请时间"
					></el-date-picker> 
				</el-form-item>
				<el-form-item class="input" v-else-if="ruleForm.shenqingshijian" label="申请时间" prop="shenqingshijian" >
					<el-input v-model="ruleForm.shenqingshijian" placeholder="申请时间" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="用户账号" prop="yonghuzhanghao" >
					<el-input v-model="ruleForm.yonghuzhanghao" placeholder="用户账号" clearable  :readonly="ro.yonghuzhanghao"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="用户账号" prop="yonghuzhanghao" >
					<el-input v-model="ruleForm.yonghuzhanghao" placeholder="用户账号" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="用户姓名" prop="yonghuxingming" >
					<el-input v-model="ruleForm.yonghuxingming" placeholder="用户姓名" clearable  :readonly="ro.yonghuxingming"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="用户姓名" prop="yonghuxingming" >
					<el-input v-model="ruleForm.yonghuxingming" placeholder="用户姓名" readonly></el-input>
				</el-form-item>
			</template>
			<el-form-item class="textarea" v-if="type!='info'" label="申请内容" prop="shenqingneirong" >
				<el-input
					style="min-width: 200px; max-width: 600px;"
					type="textarea"
					:rows="8"
					placeholder="申请内容"
					v-model="ruleForm.shenqingneirong" >
				</el-input>
			</el-form-item>
			<el-form-item v-else-if="ruleForm.shenqingneirong" label="申请内容" prop="shenqingneirong" >
				<span class="text">{{ruleForm.shenqingneirong}}</span>
			</el-form-item>
			<el-form-item v-if="type!='info'"  label="申请详情" prop="shenqingxiangqing" >
				<editor 
					style="min-width: 200px; max-width: 600px;"
					v-model="ruleForm.shenqingxiangqing" 
					class="editor" 
					action="file/upload">
				</editor>
			</el-form-item>
			<el-form-item v-else-if="ruleForm.shenqingxiangqing" label="申请详情" prop="shenqingxiangqing" >
				<span class="text ql-snow ql-editor" v-html="ruleForm.shenqingxiangqing"></span>
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
					butiemingcheng : false,
					butiefengmian : false,
					butieziliao : false,
					butiejine : false,
					shenqingzhuangtai : false,
					shenqingshijian : false,
					shenqingneirong : false,
					shenqingxiangqing : false,
					yonghuzhanghao : false,
					yonghuxingming : false,
				},
			
				ruleForm: {
					butiemingcheng: '',
					butiefengmian: '',
					butieziliao: '',
					butiejine: '',
					shenqingzhuangtai: '未通过',
					shenqingshijian: '',
					shenqingneirong: '',
					shenqingxiangqing: '',
					yonghuzhanghao: '',
					yonghuxingming: '',
				},
				shenqingzhuangtaiOptions: [],

				rules: {
					butiemingcheng: [
					],
					butiefengmian: [
					],
					butieziliao: [
					],
					butiejine: [
						{ validator: validateNumber, trigger: 'blur' },
					],
					shenqingzhuangtai: [
					],
					shenqingshijian: [
					],
					shenqingneirong: [
					],
					shenqingxiangqing: [
					],
					yonghuzhanghao: [
					],
					yonghuxingming: [
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
			this.ruleForm.shenqingshijian = this.getCurDate()
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
						if(o=='butiemingcheng'){
							this.ruleForm.butiemingcheng = obj[o];
							this.ro.butiemingcheng = true;
							continue;
						}
						if(o=='butiefengmian'){
							this.ruleForm.butiefengmian = obj[o];
							this.ro.butiefengmian = true;
							continue;
						}
						if(o=='butieziliao'){
							this.ruleForm.butieziliao = obj[o];
							this.ro.butieziliao = true;
							continue;
						}
						if(o=='butiejine'){
							this.ruleForm.butiejine = obj[o];
							this.ro.butiejine = true;
							continue;
						}
						if(o=='shenqingzhuangtai'){
							this.ruleForm.shenqingzhuangtai = obj[o];
							this.ro.shenqingzhuangtai = true;
							continue;
						}
						if(o=='shenqingshijian'){
							this.ruleForm.shenqingshijian = obj[o];
							this.ro.shenqingshijian = true;
							continue;
						}
						if(o=='shenqingneirong'){
							this.ruleForm.shenqingneirong = obj[o];
							this.ro.shenqingneirong = true;
							continue;
						}
						if(o=='shenqingxiangqing'){
							this.ruleForm.shenqingxiangqing = obj[o];
							this.ro.shenqingxiangqing = true;
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
					}
					this.ruleForm.shenqingzhuangtai = '未通过'; 				}
				// 获取用户信息
				this.$http({
					url: `${this.$storage.get('sessionTable')}/session`,
					method: "get"
				}).then(({ data }) => {
					if (data && data.code === 0) {
						var json = data.data;
						if(this.$storage.get("role")!="管理员") {
							this.ro.shenqingzhuangtai = true;
						}
						if(((json.yonghuzhanghao!=''&&json.yonghuzhanghao) || json.yonghuzhanghao==0) && this.$storage.get("role")!="管理员"){
							this.ruleForm.yonghuzhanghao = json.yonghuzhanghao
							this.ro.yonghuzhanghao = true;
						}
						if(((json.yonghuxingming!=''&&json.yonghuxingming) || json.yonghuxingming==0) && this.$storage.get("role")!="管理员"){
							this.ruleForm.yonghuxingming = json.yonghuxingming
							this.ro.yonghuxingming = true;
						}
					} else {
						this.$message.error(data.msg);
					}
				});
				this.shenqingzhuangtaiOptions = "已通过,未通过".split(',')
			
			},
			// 多级联动参数

			info(id) {
				this.$http({
					url: `shenqingbutie/info/${id}`,
					method: "get"
				}).then(({ data }) => {
					if (data && data.code === 0) {
						this.ruleForm = data.data;
						//解决前台上传图片后台不显示的问题
						let reg=new RegExp('../../../upload','g')//g代表全部
						this.ruleForm.shenqingxiangqing = this.ruleForm.shenqingxiangqing.replace(reg,'../../../GZLS_IMS/upload');
					} else {
						this.$message.error(data.msg);
					}
				});
			},

			// 提交
			async onSubmit() {
					if(this.ruleForm.butiefengmian!=null) {
						this.ruleForm.butiefengmian = this.ruleForm.butiefengmian.replace(new RegExp(this.$base.url,"g"),"");
					}
					if(this.ruleForm.butieziliao!=null) {
						this.ruleForm.butieziliao = this.ruleForm.butieziliao.replace(new RegExp(this.$base.url,"g"),"");
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
								url: `shenqingbutie/${!this.ruleForm.id ? "save" : "update"}`,
								method: "post",
								data: this.ruleForm
							}).then(async ({ data }) => {
								if (data && data.code === 0) {
									this.$message({
										message: "操作成功",
										type: "success",
										duration: 1500,
										onClose: () => {
											this.parent.showFlag = true;
											this.parent.addOrUpdateFlag = false;
											this.parent.shenqingbutieCrossAddOrUpdateFlag = false;
											this.parent.search();
											this.parent.contentStyleChange();
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
				this.parent.shenqingbutieCrossAddOrUpdateFlag = false;
				this.parent.contentStyleChange();
			},
			butiefengmianUploadChange(fileUrls) {
				this.ruleForm.butiefengmian = fileUrls;
			},
			butieziliaoUploadChange(fileUrls) {
				this.ruleForm.butieziliao = fileUrls;
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
