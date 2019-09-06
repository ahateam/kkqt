package zyxhj.kkqt.domain;

import zyxhj.utils.data.rds.RDSAnnEntity;
import zyxhj.utils.data.rds.RDSAnnField;
import zyxhj.utils.data.rds.RDSAnnID;

@RDSAnnEntity(alias = "tb_kk_task_apply")
public class KKTaskApply {

	/**
	 * 所属分组编号
	 */
	@RDSAnnID
	@RDSAnnField(column = RDSAnnField.ID)
	public Long taskId;

	@RDSAnnID
	@RDSAnnField(column = RDSAnnField.ID)
	public Long userId;

	
}
