<template>
	<section>
		<el-tag>iframe load {{url}}</el-tag>
		<iframe width="100%" :height="newHeight" :src="url" frameborder="0"></iframe>
	</section>
</template>
<script>
	export default {
		data() {
			return {
				url: 'https://ss.suixingpay.com/handBrushMerchantManagement/index'
			}
		},
		computed: {
			newHeight () {
				return 900;
			}
		}
	}
</script>