package com.contaazul.samples.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlTransient;

import lombok.NoArgsConstructor;

import com.mysema.query.annotations.QueryProjection;

@Entity(name = "lancamentos")
@NoArgsConstructor
public class Statement {

	@Id
	private Long id;

	@Column(name = "valor")
	private Double value;

	@Column(name = "data")
	private Date expirationDate;

	@ManyToOne
	@JoinColumn(name = "idbanco")
	private Banco bank;

	@Column(name = "dsbanco")
	private String bankName;

	@Column(name = "memo")
	private String description;

	@ManyToOne
	@JoinColumn(name = "categoria_id")
	private NaturezaFinanceira category;

	@Column(name = "categoria")
	private String categoryName;

	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Pessoa client;

	@Column(name = "cliente")
	private String clientName;

	@Column(name = "tipo")
	@Enumerated(EnumType.ORDINAL)
	private StatementType type;

	@Column(name = "baixado")
	@Enumerated(EnumType.ORDINAL)
	private StatementPaidOf paidOf;

	@ManyToOne
	@JoinColumn(name = "custo_id")
	private CentroCusto costCenter;

	@Column(name = "ds_centro_custo")
	private String costCenterName;

	@Column(name = "dt_boleto")
	private Date bankslipDate;

	@Column(name = "isinitialbalanceoperation")
	private Boolean initialBalance;

	@Column(name = "ultimaatualizacao")
	private Date lastChange;

	@Column(name = "tiponaturezaoperacao")
	@Enumerated(EnumType.STRING)
	private TipoNaturezaFinanceira operationNature;

	@Column(name = "lote")
	private Long lot;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_EMPRESA")
	@XmlTransient
	private Empresa empresa;

	@QueryProjection
	public Statement(Long id, Date expirationDate, String categoryName, String description, Double value) {
		super();
		this.id = id;
		this.expirationDate = expirationDate;
		this.categoryName = categoryName;
		this.description = description;
		this.value = value;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public Banco getBank() {
		return bank;
	}

	public void setBank(Banco bank) {
		this.bank = bank;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public NaturezaFinanceira getCategory() {
		return category;
	}

	public void setCategory(NaturezaFinanceira category) {
		this.category = category;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Pessoa getClient() {
		return client;
	}

	public void setClient(Pessoa client) {
		this.client = client;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public StatementType getType() {
		return type;
	}

	public void setType(StatementType type) {
		this.type = type;
	}

	public StatementPaidOf getPaidOf() {
		return paidOf;
	}

	public void setPaidOf(StatementPaidOf paidOf) {
		this.paidOf = paidOf;
	}

	public CentroCusto getCostCenter() {
		return costCenter;
	}

	public void setCostCenter(CentroCusto costCenter) {
		this.costCenter = costCenter;
	}

	public String getCostCenterName() {
		return costCenterName;
	}

	public void setCostCenterName(String costCenterName) {
		this.costCenterName = costCenterName;
	}

	public Date getBankslipDate() {
		return bankslipDate;
	}

	public void setBankslipDate(Date bankslipDate) {
		this.bankslipDate = bankslipDate;
	}

	public Boolean getInitialBalance() {
		return initialBalance;
	}

	public void setInitialBalance(Boolean initialBalance) {
		this.initialBalance = initialBalance;
	}

	public Date getLastChange() {
		return lastChange;
	}

	public void setLastChange(Date lastChange) {
		this.lastChange = lastChange;
	}

	public TipoNaturezaFinanceira getOperationNature() {
		return operationNature;
	}

	public void setOperationNature(TipoNaturezaFinanceira operationNature) {
		this.operationNature = operationNature;
	}

	public Long getLot() {
		return lot;
	}

	public void setLot(Long lot) {
		this.lot = lot;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

}
