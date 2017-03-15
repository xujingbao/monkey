<template>
	<el-form ref="form" :model="form" :label-position="left" label-width="80px" @submit.prevent="onSubmit" style="margin:20px;width:60%;min-width:600px;">
		<!--基本信息-->
		<el-card class="box-card">
			<div slot="header" class="clearfix">
				<span>基本信息</span>
			</div>
			<!--商户类型-->
			<el-row :gutter="5">
				<el-col :span="5">
					<!--<div class="grid-content bg-purple">-->
					<el-form-item label="商户类型">
						<el-select v-model="form.merchantType" placeholder="请选择">
							<el-option v-for="item in merchantTypes" :label="item.label" :value="item.value"></el-option>
						</el-select>
					</el-form-item>
					<!--</div>-->
				</el-col>
				<el-col :span="10">
					<!--<div class="grid-content bg-purple">-->
					<el-form-item label="签购单">
						<el-input v-model="form.name"></el-input>
					</el-form-item>
					<!--</div>-->
				</el-col>
				<el-col :span="8">
					<!--<div class="grid-content bg-purple">-->
					<el-form-item label="注册名称" :rules="[
      { required: true, message: '年龄不能为空'},
      { type: 'number', message: '年龄必须为数字值'}
    ]">
						<el-input v-model="form.name"></el-input>
					</el-form-item>
					<!--</div>-->
				</el-col>
			</el-row>
			<!--商户等级-->
			<el-row :gutter="5">
				<el-col :span="10">
					<el-form-item label="商户等级">
						<el-select v-model="form.merchantLevel" filterable placeholder="请选择">
							<el-option v-for="item in merchantLevels" :label="item.label" :value="item.value">
							</el-option>
						</el-select>
					</el-form-item>
				</el-col>
			</el-row>
			<!--注册地址-->
			<el-row :gutter="5">
				<el-col :span="10">
					<el-form-item label="注册地址">
						<el-cascader :options="registAddress" @active-item-change="handleItemChange" :props="props"></el-cascader>
					</el-form-item>
					<el-form-item label="街道名称">
						<el-input placeholder="街道"></el-input>
					</el-form-item>
				</el-col>
			</el-row>
			<!--装机地址-->
			<el-row :gutter="5">
				<el-col :span="10">
					<el-form-item label="装机地址">
						<el-cascader :options="registAddress" @active-item-change="handleItemChange" :props="props"></el-cascader>
					</el-form-item>
					<el-form-item label="街道名称">
						<el-input placeholder="街道"></el-input>
					</el-form-item>
				</el-col>
			</el-row>

			<el-row :gutter="5">
				<el-col :span="10">
					<el-form-item label="主营业务">
						<el-input placeholder=""></el-input>
					</el-form-item>
				</el-col>
				<el-col :span="12">
					<el-form-item label="登记号">
						<el-input placeholder=""></el-input>
					</el-form-item>
				</el-col>
			</el-row>

			<el-row :gutter="5">
				<el-col :span="8">
					<el-form-item label="业务员名称" width="100px">
						<el-select v-model="form.merchantLevel" filterable placeholder="请选择">
							<el-option v-for="item in merchantLevels" :label="item.label" :value="item.value">
							</el-option>
						</el-select>
					</el-form-item>
				</el-col>
				<el-col :span="5">
					<el-form-item label="法人姓名">
						<el-input placeholder=""></el-input>
					</el-form-item>
				</el-col>
				<el-col :span="9">
					<el-form-item label="身份证号">
						<el-input placeholder=""></el-input>
					</el-form-item>
				</el-col>
			</el-row>


			<!--<el-form-item label="活动时间">
				<el-col :span="11">
					<el-date-picker type="date" placeholder="选择日期" v-model="form.date1" style="width: 100%;"></el-date-picker>
				</el-col>
				<el-col class="line" :span="2">-</el-col>
				<el-col :span="11">
					<el-time-picker type="fixed-time" placeholder="选择时间" v-model="form.date2" style="width: 100%;"></el-time-picker>
				</el-col>
			</el-form-item>
			<el-form-item label="即时配送">
				<el-switch on-text="" off-text="" v-model="form.delivery"></el-switch>
			</el-form-item>
			<el-form-item label="活动性质">
				<el-checkbox-group v-model="form.type">
					<el-checkbox label="美食/餐厅线上活动" name="type"></el-checkbox>
					<el-checkbox label="地推活动" name="type"></el-checkbox>
					<el-checkbox label="线下主题活动" name="type"></el-checkbox>
					<el-checkbox label="单纯品牌曝光" name="type"></el-checkbox>
				</el-checkbox-group>
			</el-form-item>
			<el-form-item label="特殊资源">
				<el-radio-group v-model="form.resource">
					<el-radio label="线上品牌商赞助"></el-radio>
					<el-radio label="线下场地免费"></el-radio>
				</el-radio-group>
			</el-form-item>-->

		</el-card>
		<br/>
		<el-card class="box-card">
			<div slot="header" class="clearfix">
				<span>费率信息</span>
			</div>
		</el-card>
		<br/>
		<el-card class="box-card">
			<div slot="header" class="clearfix">
				<span>个体结算信息</span>
				<p>个体结算信息必须整组填写（对公结算信息同理），点击“开户行信息输入框查询结算银行”可以补全联行行号及开户行信息.</p>
			</div>
			<el-row :gutter="5">
				<el-col :span="12">
					<el-form-item label="账户名" width="100px">
						<el-select v-model="form.merchantLevel" filterable placeholder="请选择">
							<el-option v-for="item in merchantLevels" :label="item.label" :value="item.value">
							</el-option>
						</el-select>
					</el-form-item>
				</el-col>
				<el-col :span="12">
					<el-form-item label="结算账号">
						<el-input placeholder=""></el-input>
					</el-form-item>
				</el-col>
			</el-row>
			<el-row :gutter="5">
				<el-col :span="12">
					<el-form-item label="开户行" width="120px">
						<el-select v-model="form.merchantLevel" filterable placeholder="请选择">
							<el-option v-for="item in merchantLevels" :label="item.label" :value="item.value">
							</el-option>
						</el-select>
					</el-form-item>
				</el-col>
				<el-col :span="12">
					<el-form-item label="联行行号">
						<el-input placeholder=""></el-input>
					</el-form-item>
				</el-col>
			</el-row>
		</el-card>
		<br/>
		<el-card class="box-card">
			<div slot="header" class="clearfix">
				<span>对公结算信息</span>
			</div>
			<el-row :gutter="5">
				<el-col :span="12">
					<el-form-item label="账户名" width="100px">
						<el-select v-model="form.merchantLevel" filterable placeholder="请选择">
							<el-option v-for="item in merchantLevels" :label="item.label" :value="item.value">
							</el-option>
						</el-select>
					</el-form-item>
				</el-col>
				<el-col :span="12">
					<el-form-item label="结算账号">
						<el-input placeholder=""></el-input>
					</el-form-item>
				</el-col>
			</el-row>
			<el-row :gutter="5">
				<el-col :span="12">
					<el-form-item label="开户行" width="120px">
						<el-select v-model="form.merchantLevel" filterable placeholder="请选择">
							<el-option v-for="item in merchantLevels" :label="item.label" :value="item.value">
							</el-option>
						</el-select>
					</el-form-item>
				</el-col>
				<el-col :span="12">
					<el-form-item label="联行行号">
						<el-input placeholder=""></el-input>
					</el-form-item>
				</el-col>
			</el-row>
		</el-card>
		<br/>
		<el-card class="box-card">
			<div slot="header" class="clearfix">
				<span>其他信息</span>
			</div>
			<el-tabs v-model="form.functions" type="card" @tab-click="handleClick">
				<el-tab-pane label="功能信息" name="first">
					<el-card>
						<div slot="header" class="clearfix">
							<span>结算卡功能</span>
						</div>
						<el-form-item label="功能受理">
							<el-checkbox-group v-model="form.type">
								<el-checkbox label="一般刷卡" name="type"></el-checkbox>
								<el-checkbox label="预授权" name="type"></el-checkbox>
								<el-checkbox label="在线退货" name="type"></el-checkbox>
								<el-checkbox label="随意通结算" name="type"></el-checkbox>
							</el-checkbox-group>
						</el-form-item>
						<el-form-item label="随意通">
							<el-checkbox-group v-model="form.type">
								<el-checkbox label="非公日结算" name="type"></el-checkbox>
								<el-checkbox label="即日付" name="type"></el-checkbox>
								<el-checkbox label="其他消费" name="type"></el-checkbox>
							</el-checkbox-group>
						</el-form-item>
					</el-card>
					<br/>
					<el-card>
						<div slot="header" class="clearfix">
							<span>费用信息</span>
						</div>
						<el-form-item label="">
							<el-checkbox label="pos维护费" name="type"></el-checkbox>
							<el-checkbox label="维护通" name="type"></el-checkbox>
						</el-form-item>
					</el-card>
				</el-tab-pane>
				<el-tab-pane label="上传图片" name="second">
					<el-upload action="//jsonplaceholder.typicode.com/posts/" list-type="picture-card" :on-preview="handlePictureCardPreview"
					    :on-remove="handleRemove">
						<i class="el-icon-plus"></i>
					</el-upload>
					<el-dialog v-model="dialogVisible" size="tiny">
						<img width="100%" :src="dialogImageUrl" alt="">
					</el-dialog>
				</el-tab-pane>
			</el-tabs>
			<br/>
		</el-card>
		<br/>
		<el-card>
			<el-form-item label="备注">
				<el-input type="textarea" v-model="form.desc"></el-input>
			</el-form-item>
			<el-form-item>
				<el-button @click="submitForm('form')" type="primary">立即创建</el-button>
				<el-button @click.native.prevent>取消</el-button>
			</el-form-item>
		</el-card>
	</el-form>
</template>

<script>
	export default {
		data() {
			return {
				form: {
					name: '',
					region: '',
					date1: '',
					date2: '',
					delivery: false,
					type: [],
					resource: '',
					desc: '',

					merchantType: '',
					merchantLevel: '', // 商户等级
					registAddress: '',

				},
				dialogImageUrl: '',
				dialogVisible: false,
				// 注册地址
				registAddress: [{
					label: '北京',
					cities: []
				}, {
					label: '河北',
					cities: []
				}],
				props: {
					value: 'label',
					children: 'cities'
				},

				// 商户类型
				merchantTypes: [{
					value: '1',
					label: '普通商户'
				}, {
					value: '2',
					label: '连锁总店'
				}, {
					value: '3',
					label: '1+N分店'
				}],

				// 商户等级
				merchantLevels: [{
					value: '选项1',
					label: '一类'
				}, {
					value: '选项2',
					label: '二类'
				}, {
					value: '选项3',
					label: '三类'
				}]
			}
		},
		methods: {
			handleRemove(file, fileList) {
				console.log(file, fileList);
			},
			handlePictureCardPreview(file) {
				this.dialogImageUrl = file.url;
				this.dialogVisible = true;
			},
			handleItemChange(val) {
				console.log('active item:', val);
				setTimeout(_ => {
					if (val.indexOf('北京') > -1 && !this.registAddress[0].cities.length) {
						this.registAddress[0].cities = [{
							label: '石景山'
						}];
					} else if (val.indexOf('河北') > -1 && !this.registAddress[1].cities.length) {
						this.registAddress[1].cities = [{
							label: '沧州'
						}];
					}
				}, 300);
			},
			onSubmit() {
				console.log('submit!');
			},
			submitForm(formName) {
				this.$refs(formName).validate((valid) => {
					if(valid){
						alert('提交成功')
					}else{
						return false;
					}
				});
			}	
		}
	}
</script>