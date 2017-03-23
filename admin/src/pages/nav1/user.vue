<template>
    <section>
        <!--工具条-->
        <el-col :span="24"
                class="toolbar"
                style="padding-bottom: 0px;">
            <el-form :inline="true"
                     :model="filters">
                <el-form-item>
                    <el-input v-model="filters.name"
                              placeholder="姓名"></el-input>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary"
                               v-on:click="getUser">查询
                    </el-button>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary"
                               @click="handleAdd">新增
                    </el-button>
                </el-form-item>
            </el-form>
        </el-col>

        <!--新增界面-->
        <el-dialog title="新增"
                   v-model="addFormVisible"
                   :close-on-click-modal="false">
            <el-form :model="addForm"
                     label-width="80px"
                     :rules="addFormRules"
                     ref="addForm">
                <el-form-item label="姓名"
                              prop="name">
                    <el-input v-model="addForm.name"
                              auto-complete="off"></el-input>
                </el-form-item>
                <el-form-item label="性别">
                    <el-radio-group v-model="addForm.sex">
                        <el-radio class="radio"
                                  :label="1">男
                        </el-radio>
                        <el-radio class="radio"
                                  :label="0">女
                        </el-radio>
                    </el-radio-group>
                </el-form-item>
                <el-form-item label="年龄">
                    <el-input-number v-model="addForm.age"
                                     :min="0"
                                     :max="200"></el-input-number>
                </el-form-item>
                <el-form-item label="生日">
                    <el-date-picker type="date"
                                    placeholder="选择日期"
                                    v-model="addForm.birth"></el-date-picker>
                </el-form-item>
                <el-form-item label="地址">
                    <el-input type="textarea"
                              v-model="addForm.addr"></el-input>
                </el-form-item>
            </el-form>
            <div slot="footer"
                 class="dialog-footer">
                <el-button @click.native="addFormVisible = false">取消</el-button>
                <el-button type="primary"
                           @click.native="addSubmit"
                           :loading="addLoading">提交
                </el-button>
            </div>
        </el-dialog>

        <!--列表-->
        <template>
            <el-table :data="users"
                      highlight-current-row
                      v-loading="loading"
                      style="width: 100%;">
                <el-table-column type="index"
                                 width="60">
                </el-table-column>
                <el-table-column prop="name"
                                 label="姓名"
                                 width="120"
                                 sortable>
                </el-table-column>
                <el-table-column prop="sex"
                                 label="性别"
                                 width="100"
                                 :formatter="formatSex"
                                 sortable>
                </el-table-column>
                <el-table-column prop="age"
                                 label="年龄"
                                 width="100"
                                 sortable>
                </el-table-column>
                <el-table-column prop="birth"
                                 label="生日"
                                 width="120"
                                 sortable>
                </el-table-column>
                <el-table-column prop="addr"
                                 label="地址"
                                 min-width="180"
                                 sortable>
                </el-table-column>
            </el-table>
        </template>

    </section>
</template>
<script>
    import API from '../../api/api.js';
    import util from '../../common/js/util'
    import NProgress from 'nprogress'
    export default {
        data() {
            return {
                filters: {
                    name: ''
                },
                loading: false,
                users: [],
                addFormVisible: false, //新增界面是否显示
                addLoading: false, // 进度条是否显示
                addFormRules: { // 添加校验规则
                    name: [{
                        required: true,
                        message: '请输入姓名',
                        trigger: 'blur'
                    }]
                },
                addForm: { //新增界面数据
                    name: '',
                    sex: -1,
                    age: 0,
                    birth: '',
                    addr: ''
                }

            }
        },
        methods: {
            //性别显示转换
            formatSex: function (row, column) {
                return row.sex == 1 ? '男' : row.sex == 0 ? '女' : '未知';
            },
            //获取用户列表
            getUser: function () {
                let para = {
                    name: this.filters.name
                };
                this.loading = true;
                NProgress.start();
                API.getUserList(para).then((res) => {
                    //console.log(userArr)
                    console.log(res);
                    this.users = res;
                    this.loading = false;
                    NProgress.done();
                });
            },
            // 弹出添加画面
            handleAdd: function () {
                this.addFormVisible = true;
                this.addForm = {
                    name: '',
                    sex: -1,
                    age: 0,
                    birth: '',
                    addr: ''
                };
            },
            // 提交用户信息
            addSubmit: function () {
                this.$refs.addForm.validate((valid) => {
                    if (valid) {
                        this.$confirm('确认提交么?', '提示').then(() => {
                            let para = Object.assign({}, this.addForm)
                            para.birth = (!para.birth || para.birth == '') ? '' : util.formatDate.format(new Date(para.birth),
                                'yyyy-MM-dd');
                            console.log(para)
                            API.addUser(para).then((res) => {
                                this.addLoading = false;
                                NProgress.done();
                                this.$notify({
                                    title: '成功',
                                    message: '提交成功',
                                    type: 'success'
                                });
                                this.addFormVisible = false;
                                this.$refs['addForm'].resetFields();
                                API.getUserList();
                            })
                        })
                    }
                })
            }
        },
        mounted() {
            this.getUser();
        }
    };

</script>

<style scoped>

</style>