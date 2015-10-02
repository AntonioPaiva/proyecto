package py.consultoresinformaticos.DTO;

public class CartaGanttDTO 
{
	private String name;
	private String desc;
	private TareaInner values;

	public CartaGanttDTO(){}
	
	class TareaInner
	{
		private String from;
		private String to;
		private String label;
		private String customClass;
		
		public String getFrom() 
		{
			return from;
		}
		
		public void setFrom(String from) 
		{
			this.from = from;
		}
		
		public String getTo() 
		{
			return to;
		}
		
		public void setTo(String to) 
		{
			this.to = to;
		}
		
		public String getLabel() 
		{
			return label;
		}
		
		public void setLabel(String label) 
		{
			this.label = label;
		}
		
		public String getCustomClass() 
		{
			return customClass;
		}
		
		public void setCustomClass(String customClass) 
		{
			this.customClass = customClass;
		}
		
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getName()
	{
		return this.name;
	}

	public void setDesc(String desc)
	{
		this.desc = desc;
	}
	
	public String getDesc()
	{
		return this.desc;
	}
	
	public void setValues(String from, String to, String label, String customClass)
	{
		this.values = new TareaInner();
		values.setFrom(from);
		values.setTo(to);
		values.setLabel(label);
		values.setCustomClass(customClass);
	}
	
	public TareaInner getValues()
	{
		return this.values;
	}	
	
}
