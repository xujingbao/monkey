<template>
	<section>
		<el-tag>iframe load {{url}}</el-tag>
		<iframe width="100%" :height="newHeight" :src="url" frameborder="0" allowfullscreen></iframe>
	</section>
</template>
<script>
	export default {
		data() {
			return {
				url: 'http://www.baidu.com/'
			}
		},
		computed: {
			newHeight () {
				return 900;
			}
		}
	}
</script>