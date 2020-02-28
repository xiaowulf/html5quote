$(function() {
	$("#mainTabs").tabs({
		width : $("#mainTabs").parent().width(),
		height : $("#mainTabs").parent().height()
	});
	$('#funcTree').tree(
			{
				onClick : function(node) {
					var title = "";
					var href = "";
					var node = $('#funcTree').tree('getSelected');
					var urlaction = node.attributes.urlaction;
					var title = node.text;
					if (node.children && node.state == 'closed') {
						$('#funcTree').tree('expand', node.target);
					} else if (node.children && node.state == 'open') {
						$('#funcTree').tree('collapse', node.target);
					}
					if (title != "" && urlaction != "" && urlaction != "#"
							&& urlaction != "root") {
						addTab(title, urlaction);
						refreshTab({
							tabTitle : title,
							url : urlaction
						});
					}
				}
			});
});

function addTab(title, href) {
	var tt = $('#mainTabs');
	if (tt.tabs('exists', title)) {// 如果tab已经存在,则选中并刷新该tab
		tt.tabs('select', title);
	} else {
		var content = "";
		if (href) {
			content = '<iframe scrolling="yes" frameborder="0"  src="' + href
					+ '" style="width:100%;height:100%;"></iframe>';
		} else {
			content = '未实现';
		}
		
		tt.tabs('add', {
			title : title,
			closable : true,
			content : content
		});
	}
}

function refreshTab(cfg) {
	var refresh_tab = cfg.tabTitle ? $('#mainTabs')
			.tabs('getTab', cfg.tabTitle) : $('#mainTabs').tabs('getSelected');
	if (refresh_tab && refresh_tab.find('iframe').length > 0) {
		var _refresh_ifram = refresh_tab.find('iframe')[0];
		var refresh_url = cfg.url ? cfg.url : _refresh_ifram.src;
		_refresh_ifram.contentWindow.location.href = refresh_url;
	}
}
