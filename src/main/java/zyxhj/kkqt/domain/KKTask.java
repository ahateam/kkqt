package zyxhj.kkqt.domain;

import java.util.Date;

import com.alicloud.openservices.tablestore.model.PrimaryKeyType;
import com.alicloud.openservices.tablestore.model.search.FieldType;

import zyxhj.utils.data.AnnDicField;
import zyxhj.utils.data.ts.TSAnnEntity;
import zyxhj.utils.data.ts.TSAnnField;
import zyxhj.utils.data.ts.TSAnnID;
import zyxhj.utils.data.ts.TSAnnIndex;

/**
 * 任务墙
 */
@TSAnnEntity(alias = "tb_kk_task", indexName = "index_kk_task")
public class KKTask {

	/**
	 * 分片编号，MD5(id)，避免数据热点
	 */
	@TSAnnID(key = TSAnnID.Key.PK1, type = PrimaryKeyType.STRING)
	public String _id;

	/**
	 * 任务编号
	 */
	@TSAnnID(key = TSAnnID.Key.PK2, type = PrimaryKeyType.INTEGER)
	public Long id;

	/**
	 * 诉求分类（求表扬，求分享，求陪玩，求制作）
	 */
	@TSAnnIndex(type = FieldType.LONG, enableSortAndAgg = true, store = true)
	@TSAnnField(column = TSAnnField.ColumnType.INTEGER)
	public Byte ask;

	/**
	 * 类型
	 */
	@TSAnnIndex(type = FieldType.LONG, enableSortAndAgg = true, store = true)
	@TSAnnField(column = TSAnnField.ColumnType.INTEGER)
	public Byte type;

	/**
	 * 状态
	 */
	@TSAnnIndex(type = FieldType.LONG, enableSortAndAgg = true, store = false)
	@TSAnnField(column = TSAnnField.ColumnType.INTEGER)
	public Byte status;

	/**
	 * 创建者
	 */
	@TSAnnIndex(type = FieldType.LONG, enableSortAndAgg = true, store = true)
	@TSAnnField(column = TSAnnField.ColumnType.INTEGER)
	public Long upUserId;

	/**
	 * 任务时间
	 */
	@TSAnnIndex(type = FieldType.LONG, enableSortAndAgg = true, store = true)
	@TSAnnField(column = TSAnnField.ColumnType.INTEGER)
	public Date createTime;

	/**
	 * 标签
	 */
	@TSAnnIndex(type = FieldType.KEYWORD, enableSortAndAgg = true, store = true, isArray = true)
	@TSAnnField(column = TSAnnField.ColumnType.STRING)
	public String tags;

	/**
	 * 需求标题
	 */
	@TSAnnIndex(type = FieldType.TEXT, enableSortAndAgg = false, store = false)
	@TSAnnField(column = TSAnnField.ColumnType.STRING)
	public String title;

	/**
	 * 需求详细
	 */
	@TSAnnField(column = TSAnnField.ColumnType.STRING)
	public String detail;

	/**
	 * 保证金
	 */
	@TSAnnField(column = TSAnnField.ColumnType.DOUBLE)
	public Double deposit;

	/**
	 * 预付款
	 */
	@TSAnnField(column = TSAnnField.ColumnType.DOUBLE)
	public Double advanceAmount;

	/**
	 * 位置
	 */
	@TSAnnIndex(type = FieldType.GEO_POINT, enableSortAndAgg = true, store = true)
	@TSAnnField(column = TSAnnField.ColumnType.STRING)
	public String pos;

	/////////////////////////////////////////////
	/////////////////////////////////////////////
	/////////////////////////////////////////////

	@AnnDicField(alias = "未审核")
	public static final Byte STATUS_UNEXAMINED = 0;
	@AnnDicField(alias = "已通过")
	public static final Byte STATUS_ACCEPT = 1;
	@AnnDicField(alias = "已回绝")
	public static final Byte STATUS_REJECT = 2;
	@AnnDicField(alias = "已确认")
	public static final Byte STATUS_CONFIRM = 3;
	@AnnDicField(alias = "已提交")
	public static final Byte STATUS_COMMIT = 4;
	@AnnDicField(alias = "已成交")
	public static final Byte STATUS_FINISH = 5;
	@AnnDicField(alias = "已关闭")
	public static final Byte STATUS_CLOSED = 6;
	@AnnDicField(alias = "裁决中")
	public static final Byte STATUS_JUDGING = 7;

	@AnnDicField(alias = "求表扬")
	public static final Byte ASK_PRAISE = 0;
	@AnnDicField(alias = "求陪玩")
	public static final Byte ASK_PLAY = 1;
	@AnnDicField(alias = "求分享")
	public static final Byte ASK_SHARE = 2;
	@AnnDicField(alias = "求制作")
	public static final Byte ASK_CREATE = 3;

	@AnnDicField(alias = "图文")
	public static final Byte TYPE_H5 = 0;
	@AnnDicField(alias = "视频")
	public static final Byte TYPE_VIDEO = 1;
	@AnnDicField(alias = "GIF表情")
	public static final Byte TYPE_GIF = 2;
	@AnnDicField(alias = "音频")
	public static final Byte TYPE_AUDIO = 3;
	@AnnDicField(alias = "描述")
	public static final Byte TYPE_DESC = 4;

}
