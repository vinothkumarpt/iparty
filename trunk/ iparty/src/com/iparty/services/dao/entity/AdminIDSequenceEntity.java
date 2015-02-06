/**
 * 
 */
package com.iparty.services.dao.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;


/**
 * @author vinothkumar p t
 *
 */
@Entity
@SequenceGenerator(name="adminSequence", sequenceName="ADMIN_ID_SEQ")
public class AdminIDSequenceEntity {
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="adminSequence")
	private Integer adminId;
	
	public Integer getId(){
		return adminId;
	}
}
