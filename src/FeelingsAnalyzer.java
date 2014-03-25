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
			"adaptable", "adaptável","approve", "aprovar",
			"allow", "permitir",
			"effervesce", "efervescer",
			"stable", "estável",
			"safe", "seguro",
			"happy", "feliz", "alegre",
			"benefit", "benefício", "ajustável",
			"advance", "avanço",
			"adventurous", "ousado", "audaz",
			"affable", "afável", "cortês", "amável",
			"affectionate", "afetuoso", "carinhoso",
			"agreeable", "agradável", "encantador",
			"ambitious", "ambicioso",
			"amiable", "cordial", "bondoso",
			"amicable", "amigável", "cordial", "sincero",
			"amusing", "divertido", "que causa alegria",
			"apex", "ápice",
			"ascent", "ascensão",
			"brave", "valente", "corajoso",
			"bright", "brilhante", "luminoso", "esperto",
			"broad-minded", "liberal", "“mente aberta”",
			"calm", "calmo", "tranquilo",
			"careful", "cuidadoso", "atento",
			"charming", "charmoso", "fascinante", "encantador",
			"communicative", "comunicativo", "falador",
			"compassionate", "compassivo",
			"conscientious", "consciencioso", "cuidadoso",
			"considerate", "atencioso", "ponderado",
			"convivial", "jovial", "festivo",
			"courageous", "corajoso", "valente",
			"courteous", "cortês", "atencioso", "amável",
			"creative", "criativo",
			"decisive", "decisivo",
			"determined", "determinado", "firme", "decidido",
			"diligent", "aplicado", "zeloso", "assíduo",
			"diplomatic", "diplomático",
			"discreet", "discreto",
			"dynamic", "dinâmico",
			"easygoing", "fácil de lidar",
			"emotional", "emotivo", "sentimental",
			"energetic", "enérgico", "vigoroso",
			"enthusiastic", "entusiástico", "muito interessado",
			"extroverted", "extrovertido",
			"exuberant", "exuberante",
			"fair-minded", "justo", "imparcial",
			"faithful", "fiel", "leal",
			"fearless", "destemido",
			"forceful", "forte", "vigoroso", "poderoso", "enérgico",
			"frank", "franco", "sincero", "honesto",
			"friendly", "amigável", "cordial",
			"funny", "engraçado",
			"generous", "generoso",
			"gentle", "suave", "delicado", "meigo",
			"good", "bom",
			"hard-working", "diligente", "trabalhador",
			"high", "em alta",
			"helpful", "útil", "ajuda",
			"honest", "honesto",
			"humourous", "cômico",
			"imaginative", "imaginativo", "construtivo",
			"impartial", "imparcial",
			"independent", "independente",
			"intellectual", "intelectual",
			"intelligent", "inteligente",
			"intuitive", "intuitivo",
			"inventive", "inventivo", "engenhoso",
			"kind", "amável", "bondoso", "gentil",
			"loving", "amoroso", "afetuoso", "carinhoso",
			"loyal", "leal", "fiel",
			"modest", "modesto", "humilde",
			"neat", "limpo", "claro", "puro", "e maravilhoso", "ótimo",
			"nice", "bonito", "amável", "agradável",
			"optimistic", "otimista",
			"passionate", "apaixonado", "ardente", "agitado",
			"patient", "paciente",
			"persistent", "persistente",
			"pioneering", "pioneiro",
			"philosophical", "filosófico", "prudente", "sereno",
			"placid", "plácido", "calmo", "sereno",
			"plucky", "corajoso", "bravo",
			"polite", "polido", "cortês", "refinado",
			"positive", "positivo",
			"powerful", "poderoso", "eficaz", "influente",
			"practical", "prático", "experiente", "útil",
			"pro-active", "proativo",
			"quick-witted", "perspicaz",
			"quiet", "quieto", "sossegado", "reservado",
			"rational", "racional", "razoável", "justo",
			"reliable", "confiável",
			"reserved", "reservado", "cauteloso", "discreto",
			"resourceful", "desembaraçado",
			"romantic", "romântico",
			"self-confident", "autoconfiante",
			"self-disciplined", "autodisciplinado",
			"sensible", "sensato",
			"sensitive", "sensível",
			"shy", "tímido", "acanhado",
			"sincere", "sincero", "verdadeiro", "genuíno",
			"sociable", "sociável",
			"straightforward", "franco", "honesto", "direto",
			"sympathetic", "compreensivo", "solidário", "empático",
			"thoughtful", "atento", "cuidadoso", "pensativo",
			"tidy", "asseado", "limpo", "arrumado",
			"tough", "difícil", "árduo", "resistente",
			"unassuming", "modesto", "despretensioso",
			"understanding", "compreensivo",
			"versatile", "versátil", "flexível",
			"warmhearted", "de bom coração",
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
			"criticism", "crítica", "problema",
			"impeachment", "acusação",
			"lie", "mentira", "invadida",
			"humiliate", "humilhar",
			"disallow", "desaprovar", "proibir",
			"hacker", 
			"vírus",
			"bug", "error", "defeito", "erro",
			"threaten", "ameaçar",
			"storm", "tormenta",
			"suspend", "suspender",
			"unstable", "instável",
			"panic", "pânico",
			"rumour", "rumor",
			"speculation", "especulação",
			"protest", "protesto",
			"suspect", "suspeito",
			"unsafe", "inseguro",
			"turbulence", "turbulência",
			"unhappy", "sad", "infeliz", "triste",
			"harm", "malefício",
			"crisis", "crise",
			"aloof", "indiferente", "desinteressado",
			"arrogant", "arrogante", "presunçoso",
			"bad", "mau",
			"belligerent", "beligerante", "briguento",
			"big-headed", "arrogante", "convencido", "cheio de si",
			"bitchy", "malvado", "malicioso",
			"boastful", "orgulhoso", "arrogante",
			"bone-idle", "preguiçoso", "mandrião",
			"boring", "tedioso", "maçante", "enfadonho",
			"bossy", "mandão", "autoritário",
			"brake", "frear",
			"break", "quebra",
			"callous", "insensível",
			"cantankerous", "briguento", "irritadiço",
			"careless", "descuidado", "negligente",
			"changeable", "inconstante", "mutável",
			"clinging", "grudento", "pegajoso", "chiclete",
			"compulsive", "compulsivo",
			"conservative", "conservador", "moderado",
			"coward", "covarde",
			"cruel", "cruel", "brutal", "bárbaro",
			"cynical", "cínico",
			"deceitful", "enganoso", "doloso", "fraudulento",
			"decline", "declínio",
			"devalued", "desvalorizado",
			"dishonest", "desonesto",
			"dogmatic", "dogmático", "autoritário", "dono da verdade",
			"domineering", "dominante", "tirânico",
			"finicky", "enjoado", "frescuras",
			"flirtatious", "galanteador",
			"foolish", "tolo", "bobo", "imprudente",
			"foolhardy", "imprudente", "irrefletido",
			"fussy", "irrequieto", "meticuloso", "complicado",
			"greedy", "ganancioso",
			"grumpy", "amuado", "irritável",
			"gullible", "crédulo", "ingênuo",
			"harsh", "áspero", "severo",
			"impatient", "impaciente", "ansioso",
			"impolite", "indelicado", "descortês", "grosseiro",
			"impulsive", "impulsivo",
			"inconsiderate", "desatencioso", "irrefletido",
			"inconsistent", "inconsistente", "incompatível", "contraditório",
			"indecisive", "indeciso", "hesitante",
			"indiscreet", "indiscreto", "imprudente",
			"inflexible", "inflexível", "impassível", "implacável",
			"interfering", "perturbador",
			"intolerant", "intolerante",
			"introverted", "introvertido",
			"irresponsible", "irresponsável",
			"jealous", "ciumento", "desconfiado",
			"lazy", "preguiçoso", "indolente", "vadio",
			"low", "em baixa",
			"Machiavellian", "maquiavélico",
			"materialistic", "materialista",
			"mean", "baixo", "vil", "desprezível", "mesquinho",
			"miserly", "sovina", "avarento", "mão de vaca",
			"moody", "mal-humorado", "triste", "melancólico",
			"narrow-minded", "tacanho", "limitado", "pobre de espírito",
			"nasty", "sórdido", "desagradável", "indecente",
			"naughty", "desobiente", "malvado", "impróprio",
			"negative", "negativo",
			"nervous", "nervoso", "agitado",
			"obsessive", "obsessivo",
			"obstinate", "obstinado", "teimoso", "persistente",
			"overcritical", "excessivamente crítico",
			"overemotional", "excessivamente emocional",
			"parsimonious", "parcimonioso", "avarento",
			"patronizing", "patronising", "condescendente",
			"perverse", "obstinado", "inconveniente", "petulante",
			"pessimistic", "pessimista",
			"pompous", "pomposo",
			"possessive", "possessivo",
			"pusillanimous", "pusilânime", "covarde", "tímido",
			"quarrelsome", "briguento", "irascível",
			"quick-tempered", "facilmente irritável", "irascível",
			"resentful", "ressentido", "rancoroso",
			"retract", "retrair", "encolher",
			"rude", "rude", "descortês", "grosseiro",
			"ruthless", "implacável", "impiedoso", "cruel",
			"sanction", "sanção",
			"sarcastic", "sarcástico", "irônico",
			"secretive", "reservado", "calado", "discreto",
			"selfish", "egoísta", "interesseiro",
			"self-centred", "egocêntrico",
			"silly", "bobo", "tolo", "inocente",
			"sneaky", "furtivo", "sorrateiro", "ardiloso",
			"stingy", "mesquinho", "pão-duro", "miserável",
			"stubborn", "obstinado", "teimoso", "inflexível",
			"stupid", "estúpido", "sem inteligência",
			"superficial", "superficial", "leviano",
			"tactless", "indelicado", "grosseiro", "sem tato",
			"timid", "tímido", "acanhado", "medroso",
			"touchy", "sensível", "delicado", "melindroso",
			"thoughtless", "irrefletido", "imprudente", "descuidado",
			"truculent", "truculento", "cruel", "bárbaro", "feroz",
			"unkind", "indelicado", "grosseiro", "desatencioso",
			"unpredictable", "imprevisível",
			"unreliable", "que não se pode confiar",
			"untidy", "desleixado", "desarrumado", "relaxado",
			"untrustworthy", "que não é digno de confiança",
			"vague", "vago", "indeterminado", "indefinido", "incerto",
			"vain", "convencido", "vaidoso", "fútil",
			"vengeful", "vingativo",
			"vulgar", "vulgar", "grosseiro", "de mau gosto",
			"weak-willed", "sem força de vontade"
		};
		for(int i = 0; i < negativeWords.length; i++) {
			negativeHash.add(negativeWords[i]);
		}
	}
}
