webpackJsonp([13],{k8OY:function(t,e){},km5b:function(t,e,a){"use strict";Object.defineProperty(e,"__esModule",{value:!0});var n=a("3cXf"),i=a.n(n),r=a("x3UN"),s=a("cn9w"),l={data:function(){return{rolen:window.sessionStorage.rolen,allData:[],tableData:[],backupData:[],parkinggateTableDate:[],airportParkinggates:[],current_id:-1,updateStandOfLimitForm:{Num_of_area:"",Num_of_stand:""},updateStandOfLimitFormRules:{Num_of_area:[{required:!0,message:"区域编号不能为空！",trigger:"blur"},{type:"number",message:"必须为数字值！",trigger:"blur"}],Num_of_stand:[{required:!0,message:"限停机位编号不能为空！",trigger:"blur"},{type:"number",message:"必须为数字值！",trigger:"blur"}]},newStandOfLimitForm:{Num_of_area:"",Num_of_stand:""},newStandOfLimitFormRules:{Num_of_area:[{required:!0,message:"区域编号不能为空！",trigger:"blur"},{type:"number",message:"必须为数字值！",trigger:"blur"}],Num_of_stand:[{required:!0,message:"限停机位编号不能为空！",trigger:"blur"},{type:"number",message:"必须为数字值！",trigger:"blur"}]},select_stand:[],select_area:[],bathcesForDelete:[],NumOfStandDialog:!1,NewNumOfStandDialog:!1,multipleSelection:[],currentPage:1,totalCount:0,pageSizes:[5,10,20],PageSize:10}},created:function(){var t=this;this.getData(),""===this.$store.state.airportNameVuex&&this.$message({message:"请在航班数据页面选择测试数据！",type:"warning",offset:300,center:!0,duration:3e3});var e={airportname:this.$store.state.airportNameVuex};Object(r.E)(e).then(function(e){var a=JSON.parse(i()(e.data));console.log(a);for(var n=0;n<a.length;n++)t.airportParkinggates.push(a[n].parkinggate);console.log(t.airportParkinggates)})},mounted:function(){},methods:{check_check:function(){console.log(this.tableData)},getData:function(){var t=this,e={airportname:this.$store.state.airportNameVuex,userId:window.sessionStorage.usernamen};Object(r.l)(e).then(function(e){0==e.data.length||(t.allData=JSON.parse(i()(e.data)),t.tableData=JSON.parse(i()(t.allData)),t.totalCount=t.tableData.length,t.backupData=JSON.parse(i()(t.tableData)))})},SelectAll:function(){this.tableData=this.backupData,this.totalCount=this.tableData.length;for(var t=this.select_area,e=this.select_stand,a=[],n=0;n<this.tableData.length;n++)-1!=this.tableData[n].areaid.toString().indexOf(t)&&-1!=this.tableData[n].parkinggate.toString().indexOf(e)&&a.push(this.tableData[n]);this.tableData=a,this.totalCount=this.tableData.length,this.currentPage=1},reset:function(){this.select_stand=[],this.select_area=[],this.tableData=this.backupData,this.totalCount=this.tableData.length},delete_in_bathces:function(){for(var t=this,e=0;e<this.multipleSelection.length;e++){var a=this.multipleSelection[e];this.bathcesForDelete.push(a)}0==this.bathcesForDelete.length?this.$confirm("请选择需要删除的数据","提示",{type:"warning"}):this.$confirm("确认删除所选数据吗","提示",{type:"warning"}).then(function(){Object(r.a)(t.bathcesForDelete).then(function(){t.getData(),t.multipleSelection=[],t.bathcesForDelete=[],t.$message({message:"delete successly"})})})},Delete:function(t){var e=this;this.$confirm("确认删除所选数据吗","提示",{type:"warning"}).then(function(){var a={id:t};Object(r.d)(a).then(function(t){console.log(t)}).then(function(){e.getData(),e.$message({message:"delete successly"})})})},New:function(){this.NewNumOfStandDialog=!0,this.newStandOfLimitForm.Num_of_area="",this.newStandOfLimitForm.Num_of_stand="",this.resetNewForm()},change:function(t){this.NumOfStandDialog=!0,console.log("这行数据的id是："+t),this.current_id=t;var e=this.tableData.findIndex(function(e){if(e.id==t)return!0}),a=this.tableData[e];console.log(a),this.updateStandOfLimitForm.Num_of_area=parseInt(a.areaid),this.updateStandOfLimitForm.Num_of_stand=parseInt(a.parkinggate)},Confirm_update:function(){var t=this,e={areaid:this.updateStandOfLimitForm.Num_of_area,parkinggate:this.updateStandOfLimitForm.Num_of_stand,id:this.current_id,userId:window.sessionStorage.usernamen,updateTime:Object(s.a)()};this.$refs.updateStandOfLimitFormref.validate(function(a){if(!a)return alert("请输入相关信息"),!1;Object(r.M)(e).then(function(e){t.$message({message:"修改信息成功",type:"success",center:!0}),t.NumOfStandDialog=!1,t.getData()})})},Confirm_new:function(){var t=this,e={areaid:this.newStandOfLimitForm.Num_of_area,parkinggate:this.newStandOfLimitForm.Num_of_stand,airportname:this.$store.state.airportNameVuex,userId:window.sessionStorage.usernamen,updateTime:Object(s.a)()};this.$refs.newStandOfLimitFormref.validate(function(a){if(!a)return alert("请输入相关信息"),!1;Object(r.w)(e).then(function(){t.$message({message:"插入信息成功",type:"success",center:!0}),t.NewNumOfStandDialog=!1}).then(function(){t.getData()})})},resetNewForm:function(){this.$refs.newForm.resetFields()},resetUpdateForm:function(){this.$refs.updateForm.resetFields()},rule_detail:function(){},toggleSelection:function(t){var e=this;t?t.forEach(function(t){e.$refs.multipleTable.toggleRowSelection(t)}):this.$refs.multipleTable.clearSelection()},handleSelectionChange:function(t){this.multipleSelection=t},handleSizeChange:function(t){this.PageSize=t,this.currentPage=1},handleCurrentChange:function(t){this.currentPage=t}}},o={render:function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",[a("div",{staticClass:"crumbs"},[a("el-breadcrumb",{attrs:{separator:"/"}},[a("el-breadcrumb-item",{attrs:{to:{path:"/Dashboard"}}},[a("i",{staticClass:"el-icon-lx-text"}),t._v(" 规则配置\n      ")]),t._v(" "),a("el-breadcrumb-item",[t._v("推出滑入限制")])],1)],1),t._v(" "),a("div",{staticClass:"container"},[a("div",{staticClass:"handle-box"},[a("span",[t._v("区域编号:")]),t._v(" "),a("el-input",{staticClass:"handle-input mr10",attrs:{placeholder:"请输入"},model:{value:t.select_area,callback:function(e){t.select_area=e},expression:"select_area"}}),t._v(" "),a("span",[t._v("机位编号:")]),t._v(" "),a("el-input",{staticClass:"handle-input mr10",attrs:{placeholder:"请输入"},model:{value:t.select_stand,callback:function(e){t.select_stand=e},expression:"select_stand"}}),t._v(" "),a("el-button",{staticClass:"handle-select mr10",attrs:{type:"primary"},on:{click:t.SelectAll}},[t._v("查询")]),t._v(" "),a("el-button",{staticClass:"handle-reset mr10",on:{click:t.reset}},[t._v("重置")])],1),t._v(" "),a("div",{staticClass:"handle-box1"},[a("el-button",{staticClass:"handle-select mr10",attrs:{type:"primary",icon:"el-icon-circle-plus-outline"},on:{click:t.New}},[t._v("新建")]),t._v(" "),a("el-button",{staticClass:"handle-reset mr10",attrs:{type:"danger",icon:"el-icon-delete"},on:{click:t.delete_in_bathces}},[t._v("批量删除")])],1),t._v(" "),a("el-table",{ref:"multipleTable",staticStyle:{width:"100%"},attrs:{data:t.tableData.slice((t.currentPage-1)*t.PageSize,t.currentPage*t.PageSize),border:"","tooltip-effect":"dark"},on:{"selection-change":t.handleSelectionChange}},[a("el-table-column",{attrs:{prop:"select_box",type:"selection",width:"55",align:"center"}}),t._v(" "),a("el-table-column",{attrs:{prop:"airportname",label:"机场名称",width:"150",align:"center"}}),t._v(" "),a("el-table-column",{attrs:{prop:"areaid",label:"区域编号",width:"150",align:"center"}}),t._v(" "),a("el-table-column",{attrs:{prop:"parkinggate",label:"限制机位编号",width:"150",align:"center"}}),t._v(" "),a("el-table-column",{attrs:{prop:"updateTime",label:"最后更新时间",width:"350",align:"center","show-overflow-tooltip":""}}),t._v(" "),a("el-table-column",{attrs:{prop:"methods",label:"操作",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("el-button",{attrs:{type:"text",icon:"el-icon-edit"},on:{click:function(a){return t.change(e.row.id)}}},[t._v("修改")]),t._v(" "),a("el-button",{staticClass:"red",attrs:{type:"text",icon:"el-icon-delete"},on:{click:function(a){return t.Delete(e.row.id)}}},[t._v("删除")])]}}])})],1),t._v(" "),a("el-dialog",{ref:"updateForm",attrs:{visible:t.NumOfStandDialog,width:"50%",title:"修改区域内限停机位"},on:{"update:visible":function(e){t.NumOfStandDialog=e}}},[a("el-form",{ref:"updateStandOfLimitFormref",staticClass:"form-inline",attrs:{inline:!0,model:t.updateStandOfLimitForm,rules:t.updateStandOfLimitFormRules}},[a("el-form-item",{attrs:{label:"区域编号",prop:"Num_of_area"}},[a("el-input",{attrs:{placeholder:"区域编号"},model:{value:t.updateStandOfLimitForm.Num_of_area,callback:function(e){t.$set(t.updateStandOfLimitForm,"Num_of_area",t._n(e))},expression:"updateStandOfLimitForm.Num_of_area"}})],1),t._v(" "),a("el-form-item",{attrs:{label:"限制机位编号",prop:"Num_of_stand"}},[a("el-select",{attrs:{placeholder:"请选择限制机位编号"},model:{value:t.updateStandOfLimitForm.Num_of_stand,callback:function(e){t.$set(t.updateStandOfLimitForm,"Num_of_stand",t._n(e))},expression:"updateStandOfLimitForm.Num_of_stand"}},t._l(t.airportParkinggates,function(t){return a("el-option",{key:t,attrs:{label:t,value:t}})}),1)],1),t._v(" "),a("el-form-item",[a("el-button",{attrs:{type:"primary"},on:{click:t.Confirm_update}},[t._v("确认修改")])],1)],1)],1),t._v(" "),a("el-dialog",{ref:"newForm",attrs:{visible:t.NewNumOfStandDialog,width:"50%",title:"新建区域内限停机位"},on:{"update:visible":function(e){t.NewNumOfStandDialog=e}}},[a("el-form",{ref:"newStandOfLimitFormref",staticClass:"form-inlinareae",attrs:{inline:!0,model:t.newStandOfLimitForm,rules:t.newStandOfLimitFormRules}},[a("el-form-item",{attrs:{label:"区域编号",prop:"Num_of_area"}},[a("el-input",{attrs:{placeholder:"请输入区域编号"},model:{value:t.newStandOfLimitForm.Num_of_area,callback:function(e){t.$set(t.newStandOfLimitForm,"Num_of_area",t._n(e))},expression:"newStandOfLimitForm.Num_of_area"}})],1),t._v(" "),a("el-form-item",{attrs:{label:"机位编号",prop:"Num_of_stand"}},[a("el-select",{attrs:{placeholder:"请选择限制机位编号"},model:{value:t.newStandOfLimitForm.Num_of_stand,callback:function(e){t.$set(t.newStandOfLimitForm,"Num_of_stand",t._n(e))},expression:"newStandOfLimitForm.Num_of_stand"}},t._l(t.airportParkinggates,function(t){return a("el-option",{key:t,attrs:{label:t,value:t}})}),1)],1),t._v(" "),a("el-form-item",[a("el-button",{attrs:{type:"primary"},on:{click:t.Confirm_new}},[t._v("确认添加")])],1)],1)],1),t._v(" "),a("div",{staticClass:"pagination",staticStyle:{float:"right"}},[a("el-pagination",{attrs:{background:"",layout:"total, sizes, prev, pager, next, jumper","current-page":t.currentPage,"page-sizes":t.pageSizes,"page-size":t.PageSize,total:t.totalCount},on:{"current-change":t.handleCurrentChange,"size-change":t.handleSizeChange}})],1),t._v(" "),a("div",{staticClass:"handle-box2"},[a("el-button",{on:{click:function(e){return t.toggleSelection()}}},[t._v("取消选择")])],1)],1)])},staticRenderFns:[]};var u=a("C7Lr")(l,o,!1,function(t){a("k8OY")},"data-v-33a4e25f",null);e.default=u.exports}});
//# sourceMappingURL=13.6b7f2d98e72f80db72a0.js.map