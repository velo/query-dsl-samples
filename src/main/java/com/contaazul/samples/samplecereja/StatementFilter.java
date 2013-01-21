package com.contaazul.samples.samplecereja;

import java.util.Date;
import java.util.List;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter(AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Accessors(fluent = true)
public class StatementFilter {

	private Date start;
	private Date end;
	private List<Long> banks;
	private List<Long> categories;
	private String description;

	private int page = 0;
	private int pageSize = 50;


}
