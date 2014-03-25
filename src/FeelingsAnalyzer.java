import java.util.HashSet;
import java.util.List;


public class FeelingsAnalyzer {
	private String[] positiveWords;
	private String[] negativeWords;
	private HashSet<String> positiveHash;
	private HashSet<String> negativeHash;
	
	public HashSet<String> getPositiveHash() {
		return positiveHash;
	}

	public HashSet<String> getNegativeHash() {
		return negativeHash;
	}

	public FeelingsAnalyzer() {
		super();
		positiveHash = new HashSet<String>();
		negativeHash = new HashSet<String>();
	}

	public String[] getPositiveWords() {
		return positiveWords;
	}

	public void setPositiveWords(String[] positiveWords) {
		positiveWords = positiveWords;
	}

	public String[] getNegativeWords() {
		return negativeWords;
	}

	public void setNegativeWords(String[] negativeWords) {
		negativeWords = negativeWords;
	}
	
	public void feedPositiveWords() {
		positiveWords = new String[] {
			"adaptable", "adapt�vel","approve", "aprovar",
			"allow", "permitir",
			"effervesce", "efervescer",
			"stable", "est�vel",
			"safe", "seguro",
			"happy", "feliz", "alegre",
			"benefit", "benef�cio", "ajust�vel",
			"advance", "avan�o",
			"adventurous", "ousado", "audaz",
			"affable", "af�vel", "cort�s", "am�vel",
			"affectionate", "afetuoso", "carinhoso",
			"agreeable", "agrad�vel", "encantador",
			"ambitious", "ambicioso",
			"amiable", "cordial", "bondoso",
			"amicable", "amig�vel", "cordial", "sincero",
			"amusing", "divertido", "que causa alegria",
			"apex", "�pice",
			"ascent", "ascens�o",
			"brave", "valente", "corajoso",
			"bright", "brilhante", "luminoso", "esperto",
			"broad-minded", "liberal", "�mente aberta�",
			"calm", "calmo", "tranquilo",
			"careful", "cuidadoso", "atento",
			"charming", "charmoso", "fascinante", "encantador",
			"communicative", "comunicativo", "falador",
			"compassionate", "compassivo",
			"conscientious", "consciencioso", "cuidadoso",
			"considerate", "atencioso", "ponderado",
			"convivial", "jovial", "festivo",
			"courageous", "corajoso", "valente",
			"courteous", "cort�s", "atencioso", "am�vel",
			"creative", "criativo",
			"decisive", "decisivo",
			"determined", "determinado", "firme", "decidido",
			"diligent", "aplicado", "zeloso", "ass�duo",
			"diplomatic", "diplom�tico",
			"discreet", "discreto",
			"dynamic", "din�mico",
			"easygoing", "f�cil de lidar",
			"emotional", "emotivo", "sentimental",
			"energetic", "en�rgico", "vigoroso",
			"enthusiastic", "entusi�stico", "muito interessado",
			"extroverted", "extrovertido",
			"exuberant", "exuberante",
			"fair-minded", "justo", "imparcial",
			"faithful", "fiel", "leal",
			"fearless", "destemido",
			"forceful", "forte", "vigoroso", "poderoso", "en�rgico",
			"frank", "franco", "sincero", "honesto",
			"friendly", "amig�vel", "cordial",
			"funny", "engra�ado",
			"generous", "generoso",
			"gentle", "suave", "delicado", "meigo",
			"good", "bom",
			"hard-working", "diligente", "trabalhador",
			"high", "em alta",
			"helpful", "�til", "ajuda",
			"honest", "honesto",
			"humourous", "c�mico",
			"imaginative", "imaginativo", "construtivo",
			"impartial", "imparcial",
			"independent", "independente",
			"intellectual", "intelectual",
			"intelligent", "inteligente",
			"intuitive", "intuitivo",
			"inventive", "inventivo", "engenhoso",
			"kind", "am�vel", "bondoso", "gentil",
			"loving", "amoroso", "afetuoso", "carinhoso",
			"loyal", "leal", "fiel",
			"modest", "modesto", "humilde",
			"neat", "limpo", "claro", "puro", "e maravilhoso", "�timo",
			"nice", "bonito", "am�vel", "agrad�vel",
			"optimistic", "otimista",
			"passionate", "apaixonado", "ardente", "agitado",
			"patient", "paciente",
			"persistent", "persistente",
			"pioneering", "pioneiro",
			"philosophical", "filos�fico", "prudente", "sereno",
			"placid", "pl�cido", "calmo", "sereno",
			"plucky", "corajoso", "bravo",
			"polite", "polido", "cort�s", "refinado",
			"positive", "positivo",
			"powerful", "poderoso", "eficaz", "influente",
			"practical", "pr�tico", "experiente", "�til",
			"pro-active", "proativo",
			"quick-witted", "perspicaz",
			"quiet", "quieto", "sossegado", "reservado",
			"rational", "racional", "razo�vel", "justo",
			"reliable", "confi�vel",
			"reserved", "reservado", "cauteloso", "discreto",
			"resourceful", "desembara�ado",
			"romantic", "rom�ntico",
			"self-confident", "autoconfiante",
			"self-disciplined", "autodisciplinado",
			"sensible", "sensato",
			"sensitive", "sens�vel",
			"shy", "t�mido", "acanhado",
			"sincere", "sincero", "verdadeiro", "genu�no",
			"sociable", "soci�vel",
			"straightforward", "franco", "honesto", "direto",
			"sympathetic", "compreensivo", "solid�rio", "emp�tico",
			"thoughtful", "atento", "cuidadoso", "pensativo",
			"tidy", "asseado", "limpo", "arrumado",
			"tough", "dif�cil", "�rduo", "resistente",
			"unassuming", "modesto", "despretensioso",
			"understanding", "compreensivo",
			"versatile", "vers�til", "flex�vel",
			"warmhearted", "de bom cora��o",
			"willing", "disposto", "propenso",
			"witty", "engenhoso", "arguto", "espirituoso"
		};
		for(int i = 0; i < positiveWords.length; i++) {
			positiveHash.add(positiveWords[i]);
		}
	}
	
	public void feedNegativeWords() {
		negativeWords = new String[] {
			"aggressive", "agressivo","fraud", "fraude", "despencar",
			"criticism", "cr�tica", "problema",
			"impeachment", "acusa��o",
			"lie", "mentira", "invadida",
			"humiliate", "humilhar",
			"disallow", "desaprovar", "proibir",
			"hacker", 
			"v�rus",
			"bug", "error", "defeito", "erro",
			"threaten", "amea�ar",
			"storm", "tormenta",
			"suspend", "suspender",
			"unstable", "inst�vel",
			"panic", "p�nico",
			"rumour", "rumor",
			"speculation", "especula��o",
			"protest", "protesto",
			"suspect", "suspeito",
			"unsafe", "inseguro",
			"turbulence", "turbul�ncia",
			"unhappy", "sad", "infeliz", "triste",
			"harm", "malef�cio",
			"crisis", "crise",
			"aloof", "indiferente", "desinteressado",
			"arrogant", "arrogante", "presun�oso",
			"bad", "mau",
			"belligerent", "beligerante", "briguento",
			"big-headed", "arrogante", "convencido", "cheio de si",
			"bitchy", "malvado", "malicioso",
			"boastful", "orgulhoso", "arrogante",
			"bone-idle", "pregui�oso", "mandri�o",
			"boring", "tedioso", "ma�ante", "enfadonho",
			"bossy", "mand�o", "autorit�rio",
			"brake", "frear",
			"break", "quebra",
			"callous", "insens�vel",
			"cantankerous", "briguento", "irritadi�o",
			"careless", "descuidado", "negligente",
			"changeable", "inconstante", "mut�vel",
			"clinging", "grudento", "pegajoso", "chiclete",
			"compulsive", "compulsivo",
			"conservative", "conservador", "moderado",
			"coward", "covarde",
			"cruel", "cruel", "brutal", "b�rbaro",
			"cynical", "c�nico",
			"deceitful", "enganoso", "doloso", "fraudulento",
			"decline", "decl�nio",
			"devalued", "desvalorizado",
			"dishonest", "desonesto",
			"dogmatic", "dogm�tico", "autorit�rio", "dono da verdade",
			"domineering", "dominante", "tir�nico",
			"finicky", "enjoado", "frescuras",
			"flirtatious", "galanteador",
			"foolish", "tolo", "bobo", "imprudente",
			"foolhardy", "imprudente", "irrefletido",
			"fussy", "irrequieto", "meticuloso", "complicado",
			"greedy", "ganancioso",
			"grumpy", "amuado", "irrit�vel",
			"gullible", "cr�dulo", "ing�nuo",
			"harsh", "�spero", "severo",
			"impatient", "impaciente", "ansioso",
			"impolite", "indelicado", "descort�s", "grosseiro",
			"impulsive", "impulsivo",
			"inconsiderate", "desatencioso", "irrefletido",
			"inconsistent", "inconsistente", "incompat�vel", "contradit�rio",
			"indecisive", "indeciso", "hesitante",
			"indiscreet", "indiscreto", "imprudente",
			"inflexible", "inflex�vel", "impass�vel", "implac�vel",
			"interfering", "perturbador",
			"intolerant", "intolerante",
			"introverted", "introvertido",
			"irresponsible", "irrespons�vel",
			"jealous", "ciumento", "desconfiado",
			"lazy", "pregui�oso", "indolente", "vadio",
			"low", "em baixa",
			"Machiavellian", "maquiav�lico",
			"materialistic", "materialista",
			"mean", "baixo", "vil", "desprez�vel", "mesquinho",
			"miserly", "sovina", "avarento", "m�o de vaca",
			"moody", "mal-humorado", "triste", "melanc�lico",
			"narrow-minded", "tacanho", "limitado", "pobre de esp�rito",
			"nasty", "s�rdido", "desagrad�vel", "indecente",
			"naughty", "desobiente", "malvado", "impr�prio",
			"negative", "negativo",
			"nervous", "nervoso", "agitado",
			"obsessive", "obsessivo",
			"obstinate", "obstinado", "teimoso", "persistente",
			"overcritical", "excessivamente cr�tico",
			"overemotional", "excessivamente emocional",
			"parsimonious", "parcimonioso", "avarento",
			"patronizing", "patronising", "condescendente",
			"perverse", "obstinado", "inconveniente", "petulante",
			"pessimistic", "pessimista",
			"pompous", "pomposo",
			"possessive", "possessivo",
			"pusillanimous", "pusil�nime", "covarde", "t�mido",
			"quarrelsome", "briguento", "irasc�vel",
			"quick-tempered", "facilmente irrit�vel", "irasc�vel",
			"resentful", "ressentido", "rancoroso",
			"retract", "retrair", "encolher",
			"rude", "rude", "descort�s", "grosseiro",
			"ruthless", "implac�vel", "impiedoso", "cruel",
			"sanction", "san��o",
			"sarcastic", "sarc�stico", "ir�nico",
			"secretive", "reservado", "calado", "discreto",
			"selfish", "ego�sta", "interesseiro",
			"self-centred", "egoc�ntrico",
			"silly", "bobo", "tolo", "inocente",
			"sneaky", "furtivo", "sorrateiro", "ardiloso",
			"stingy", "mesquinho", "p�o-duro", "miser�vel",
			"stubborn", "obstinado", "teimoso", "inflex�vel",
			"stupid", "est�pido", "sem intelig�ncia",
			"superficial", "superficial", "leviano",
			"tactless", "indelicado", "grosseiro", "sem tato",
			"timid", "t�mido", "acanhado", "medroso",
			"touchy", "sens�vel", "delicado", "melindroso",
			"thoughtless", "irrefletido", "imprudente", "descuidado",
			"truculent", "truculento", "cruel", "b�rbaro", "feroz",
			"unkind", "indelicado", "grosseiro", "desatencioso",
			"unpredictable", "imprevis�vel",
			"unreliable", "que n�o se pode confiar",
			"untidy", "desleixado", "desarrumado", "relaxado",
			"untrustworthy", "que n�o � digno de confian�a",
			"vague", "vago", "indeterminado", "indefinido", "incerto",
			"vain", "convencido", "vaidoso", "f�til",
			"vengeful", "vingativo",
			"vulgar", "vulgar", "grosseiro", "de mau gosto",
			"weak-willed", "sem for�a de vontade"
		};
		for(int i = 0; i < negativeWords.length; i++) {
			negativeHash.add(negativeWords[i]);
		}
	}
}
